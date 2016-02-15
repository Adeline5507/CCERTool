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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HTMLParser {
	private static final Logger log = LoggerFactory.getLogger(HTMLParser.class);
	public static HashMap getTableContent(String url,String[] keysZh) throws ParserException{
		List keyWords = new ArrayList();
		Collections.addAll(keyWords, keysZh);
		Parser parser = new Parser(url);
		parser.setEncoding("UTF-8");
		NodeFilter nodeFilter = new NodeFilter(){
			public boolean accept(Node node) {
				if(node.getText().toUpperCase().startsWith("P")&&node.getFirstChild()!=null && node.getFirstChild().getText().toUpperCase().startsWith("SPAN")){
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
				String temp = spans.elementAt(j).getFirstChild()==null?"":spans.elementAt(j).getFirstChild().getText();
				if(keyWords.contains(temp)){
					sb.append("\n");
					sb.append(temp);
					sb.append("::");
				}else{
					sb.append(temp);
				}
			}
			
		}
		String content = sb.toString().substring(1);
		log.debug("content:"+content);
		String[] contentArray = content.split("\n");
		HashMap contentMap = new HashMap();
		for(int i=0;i<contentArray.length;i++){
			contentMap.put(contentArray[i].split("::")[0], contentArray[i].split("::").length==1?"":contentArray[i].split("::")[1]);
		}
		
		for (Iterator keys = contentMap.keySet().iterator(); keys.hasNext();) {
			String key = (String)keys.next();
			log.info(key+":"+contentMap.get(key));
			
		}
		
		return contentMap;
	}
	
	public static void main(String[]args) throws ParserException{
		
		//String[] keysEn = {"registration_number","project_name","project_developer","project_category","project_type","project_methodology","planned_annual_er","er_date","validator","validator_report_file","registration_date","ppd_file"};
		
	}
}