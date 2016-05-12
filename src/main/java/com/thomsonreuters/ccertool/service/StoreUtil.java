package com.thomsonreuters.ccertool.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreUtil {

	public static float stringToFloat(String ori){
		if(ori==null){
			return 0;
		}
		
		return Float.parseFloat(ori);
	}
	
	public static int stringToInt(String ori){
		if(ori==null){
			return 0;
		}
		return Integer.parseInt(ori);
	}
	
	
	public static Date stringToDate(String ori) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return df.parse(ori);
		 
	}
}
