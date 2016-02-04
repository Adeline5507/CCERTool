package com.thomsonreuters.ccertool.parse;

import java.io.IOException;
import java.util.HashMap;

import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsePhaseTwo {
	private static final Logger log = LoggerFactory.getLogger(ParsePhaseTwo.class);
	
	public void getPhaseTwoInfo() throws IOException, ParserException{
		
		String[] keysZh = {"备案号","项目活动名称","项目业主","项目类别","项目类型","方法学","预计减排量","计入期","审定机构","审定报告","备案时间","其他相关文件"};
		HashMap contentMap = HTMLParser.getTableContent("http://cdm.ccchina.gov.cn/Detail.aspx?newsId=47637&TId=164",keysZh);
		
	}
	
}
