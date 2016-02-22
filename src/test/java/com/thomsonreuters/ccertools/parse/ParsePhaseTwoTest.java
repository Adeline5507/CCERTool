package com.thomsonreuters.ccertools.parse;
import java.io.IOException;

import org.htmlparser.util.ParserException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.parse.ParsePhaseTwo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ParsePhaseTwoTest {
	ParsePhaseTwo phaseTwo = new ParsePhaseTwo();
	@Test
	public void parseTest() throws ParserException, IOException{
		System.out.println("========================解析结果 begin=================================");
		phaseTwo.getPhaseTwoInfo("http://cdm.ccchina.gov.cn/Detail.aspx?newsId=47637&TId=164");
		System.out.println("========================解析结果 end=================================");
	
	}
}
