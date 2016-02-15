package com.thomsonreuters.ccertool.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseUtil {
	private static final Logger log = LoggerFactory.getLogger(ParseUtil.class);
	/**
	 * 替换掉不需要的换行符
	 * @param str 原字符串，可能包含换行符
	 * @return
	 */
	public static String replaceLinebreak(String str){
		if(str==null)return "";
		return str.replaceAll("\\s", "");
	} 
	/**
	 * 根据正则表达式匹配并返回匹配值
	 * @param regName
	 * @param reg
	 * @param info
	 * @return
	 */
	public static String findByRegEx(String regName,String reg,String info){
		return findByRegEx(regName,reg,info,1);
	}
	
	public static String findByRegEx(String regName,String reg,String info,int groupIndex){
		//log.info("reg:"+reg);
		Pattern pattern = Pattern.compile(reg,Pattern.UNIX_LINES);
		Matcher matcher = pattern.matcher(info);
		String value="";
		if(matcher.find()){
			value =  replaceLinebreak(matcher.group(groupIndex));
			log.info(regName+":"+value);
		}else{
			log.error(regName+" not found");
		}
		
		return value;
	}
}
