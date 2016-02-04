package com.thomsonreuters.ccertool.downloader;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HTTPDownloader {
	private static final Logger log = LoggerFactory.getLogger(HTTPDownloader.class);
	private static HttpClient client = HttpClients.createDefault();
	public static void main(String[] args) throws ClientProtocolException, IOException{
		
		getWebPageContent("http://cdm.ccchina.gov.cn/Detail.aspx?newsId=47637&TId=164");
		
	}
	
	public static String getWebPageContent(String url) throws ClientProtocolException, IOException{
		HttpGet httpget = new HttpGet(url);
		httpget.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, " +
                "like Gecko) Chrome/29.0.1547.66 Safari/537.36");
		httpget.addHeader("Content-Type", "text/plain");
		httpget.addHeader("Accept-Encoding", "gzip, deflate");
		httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		HttpResponse response = client.execute(httpget);
		HttpEntity entity = response.getEntity();
		String content=null;
		if(entity != null){
			content = EntityUtils.toString(entity);
		}
		log.info("CONTENT:"+content);
		return content;
	}

}
