package com.thomsonreuters.ccertool.downloader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PddDownloader {
	
	private static final String MAIN_URL = "http://cdm.ccchina.gov.cn/";
	private static final String PDD_MAIN_URL = "http://cdm.ccchina.gov.cn/sdxm.aspx?clmId=163";
	private static final String SAVED_DIR = "\\\\copp-tenfile01\\PointCarbon\\Common\\CCER\\issuance\\pdd\\";
	private static final String TIME_FILE = "latesttime.txt";
	private static final String TMP_FILE = "tmp.pdf.tmp";
	private static final Logger log = LoggerFactory.getLogger(PddDownloader.class);
	
	public static void main(String[] args){
		PddDownloader downloader = new PddDownloader();
		downloader.doDownLoad();
	}
	
	public void doDownLoad() {
		StringBuffer res = new StringBuffer("本次下载时间："+new Date()+"\n");
		res.append("\n").append("下载文件：").append("\n");
		try{
			List<String> urls = getToBeDownloadedPdfUrl();
			if(urls.size()==0){
				log.info("本次没有要下载的文件，所下载文件已经最新");
				res.append("本次没有要下载的文件，所下载文件已经最新");
			}else{
				for(String url:urls){
					String filename = downloadPdf(url);
					res.append(filename).append("\n");
				}
				
				//更新timestamp
				writeLatestTimestampToFile(getTimestampFromUrl(urls.get(0)));
			}
			
		}catch(Exception e){
			log.error("error happend when downloading pdf",e);
			res.append("下载过程出现错误，具体查看 downloadPdf.log");
		}
		
		//把下载结果概要写入文件
		writeStringToFile(SAVED_DIR+"result.txt",res.toString());
	}
	/**
	 * 下载指定pdf
	 * @param url pdf地址
	 * @return 下载后保存的全路径
	 * @throws Exception 
	 */
	public String downloadPdf(String url) throws Exception{
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream is = conn.getInputStream();
		
		String fileName = getTimestampFromUrl(url);
		Path tmp = Paths.get(SAVED_DIR).resolve(TMP_FILE);
		Path out = Paths.get(SAVED_DIR).resolve(fileName+".pdf");
		OutputStream os = Files.newOutputStream(tmp);
		log.info(String.format(
				"Downloading %s (%s)", u.toString(), conn
						.getURL().toString()));
		
		//开始下载
		byte[] buffer = new byte[1024 * 1024];
		int len;
		long size = 0;
		while ((len = is.read(buffer)) > -1) {
			os.write(buffer, 0, len);
			size += len;
			log.info(size + " bytes has been downloaded...");
		}
		

		Files.move(tmp, out,
				StandardCopyOption.REPLACE_EXISTING);
		log.info("Downloaded " + out.toString()+" finished");
		conn.disconnect();
		
		return out.toString();
		
	}
	
	/**
	 * 获得要下载的pdf地址
	 * 根据时间戳来判断，下载比上次时间戳新的记录，下载完成后保存最新的下载时间戳
	 * 此实现是假设网站上的记录按照时间倒序排列
	 * @return
	 * @throws Exception 
	 */
	public List<String> getToBeDownloadedPdfUrl() throws Exception{
		
		String page = getPage(0);
		int pageNum = getTotalPageNum(page);
		
		List<String> toBeDownloaded = new ArrayList<String>();
		for(int i=0;i<pageNum;i++){
			page = getPage(i);
			List urlList = getUrlsInPage(page);
			for(int j=0;j<urlList.size();j++){
				String pdfUrl = getPdfUrlAfterRedirect((String)urlList.get(j));
				if(isNew(pdfUrl)){
					toBeDownloaded.add(pdfUrl);
				}else{
					return toBeDownloaded;
				}
			}
		}
		return toBeDownloaded;
	}
	
	
	private void writeStringToFile(String path,String content){
		FileWriter fw;
		BufferedWriter bw ;
		try {
			fw = new FileWriter(path);
		    bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			fw.close();
		} catch (IOException e) {
			log.error("error happend when writting to file",e);
		}
	}
	
	private int getTotalPageNum(String page){
		Pattern p = Pattern.compile("/共(\\d+)页");
		Matcher m = p.matcher(page);
		if(m.find()){
			return Integer.parseInt(m.group(1));
		}else{
			log.error("cannot get total page number");
			return 0;
		}
		
	}
	
	
	private String getLatestTimestamp() throws Exception{
		File file = new File(SAVED_DIR+TIME_FILE);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		br.close();
		return line;
	}
	
	
	private void writeLatestTimestampToFile(String timestamp) throws Exception{
		writeStringToFile(SAVED_DIR+TIME_FILE,timestamp);
	}
	
	private String getPage(int i) throws Exception{
		String url = PDD_MAIN_URL + "&page=" + i;
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				conn.getInputStream()))) {
			String line = null;
			String res = "";
			while ((line = br.readLine()) != null) {
				res += "\r\n" + line;
			}
			return res;
		}
	}
	
	private List<String> getUrlsInPage(String page){
		List<String> urls = new ArrayList<String>();
		Pattern p = Pattern.compile("zyDetail.aspx\\?newsId=\\d+&TId=163");
		Matcher m = p.matcher(page);
		while (m.find()) {
			urls.add(MAIN_URL+m.group());
		}
		return urls;
	}
	
	
	private String getPdfUrlAfterRedirect(String url) throws Exception{
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		log.debug("返回码: " + conn.getResponseCode());
		return conn.getURL().toString();
	}
	
	
	
	private String getTimestampFromUrl(String url){
		String timestamp = null;
		Pattern p = Pattern
				.compile("archiver/cdmcn/UpFile/Files/Default/(\\d+).pdf");
		Matcher m = p.matcher(url);
		if (m.find()) {
			timestamp = m.group(1);
		}
		return timestamp;
	}
	
	private boolean isNew(String url) throws Exception{
		String timestamp = getTimestampFromUrl(url);
		if(timestamp==null){
			log.error("cannot get timestamp from pdf");
			return false;
		}
		
		String latestTimestamp = getLatestTimestamp();
		if(timestamp.compareTo(latestTimestamp)>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	

}
