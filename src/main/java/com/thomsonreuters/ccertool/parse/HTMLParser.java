package com.thomsonreuters.ccertool.parse;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;


public class HTMLParser {
	public static void main(String[]args) throws ParserException{
		String[] keysZh = {"备案号","项目活动名称","项目业主","项目类别","项目类型","方法学","预计减排量","计入期","审定机构","审定报告","备案时间","其他相关文件"};
		//String[] keysEn = {"registration_number","project_name","project_developer","project_category","project_type","project_methodology","planned_annual_er","er_date","validator","validator_report_file","registration_date","ppd_file"};
		List keyWords = new ArrayList();
		Collections.addAll(keyWords, keysZh);
//		HashMap keyMap = new HashMap();
//		for(int i=0;i<keysZh.length;i++){
//			keyMap.put(keysZh[i], keysEn[i]);
//		}
		
		Parser parser = new Parser("http://cdm.ccchina.gov.cn/Detail.aspx?newsId=47637&TId=164");
		parser.setEncoding("UTF-8");
		NodeFilter nodeFilter = new NodeFilter(){
			public boolean accept(Node node) {
				if(node.getText().startsWith("P")&&node.getFirstChild()!=null && node.getFirstChild().getText().startsWith("SPAN")){
					return true;
				}else{
					return false;
				}
			}
			
		};
		
		NodeList list = parser.extractAllNodesThatMatch(nodeFilter);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size();i++){
			Node node = list.elementAt(i);
			NodeList spans = node.getChildren();
			for(int j=0;j<spans.size();j++){
				String temp = spans.elementAt(j).getFirstChild().getText();
				if(keyWords.contains(temp)){
					sb.append("\n");
					sb.append(temp);
					sb.append(":");
				}else{
					sb.append(temp);
				}
			}
			
		}
		String content = sb.toString().substring(1);
		System.out.println("content:"+content);
		String[] contentArray = content.split("\n");
		HashMap contentMap = new HashMap();
		for(int i=0;i<contentArray.length;i++){
			contentMap.put(contentArray[i].split(":")[0], contentArray[i].split(":").length==1?"":contentArray[i].split(":")[1]);
		}
		
		System.out.println("size:"+contentMap.size());
		for (Iterator keys = contentMap.keySet().iterator(); keys.hasNext();) {
			String key = (String)keys.next();
			System.out.println(key+":"+contentMap.get(key));
			
		}
	}
}