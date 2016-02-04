package com.thomsonreuters.ccertool.parse;

import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsePhaseFour {
	private static final Logger log = LoggerFactory.getLogger(ParsePhaseFour.class);
	public void parseInfo(String url) throws ParserException{
		String[] keysZh={"项目备案号","项目名称","项目业主","第一次减排量备案","备案减排量","产生减排量时间","监测报告","核证机构","核证报告"};
		HTMLParser.getTableContent(url, keysZh);
		
	}
}
