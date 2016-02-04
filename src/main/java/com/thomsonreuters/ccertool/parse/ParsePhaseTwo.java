package com.thomsonreuters.ccertool.parse;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsePhaseTwo {
	private static final Logger log = LoggerFactory.getLogger(ParsePhaseTwo.class);
	
	public void getPhaseTwoInfo(String info) throws IOException{
		//备案号
		//String registrationNumber =  ParseUtil.findByRegEx("REGISTRATION_NUMBER",ParsePDFRegEx.REGISTRATION_NUMBER.getRegEx(),info);
		//		预计减排量			planned_annual_er	
		//		计入期起始			er_start_date	
		//		计入期截至			er_end_date	
		//		审定机构			validator	

		
	}
	
}
