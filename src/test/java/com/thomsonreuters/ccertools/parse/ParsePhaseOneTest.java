package com.thomsonreuters.ccertools.parse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.downloader.PddDownloader;
import com.thomsonreuters.ccertool.parse.ParsePhaseOne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ParsePhaseOneTest {
	ParsePhaseOne phaseOne = new ParsePhaseOne();
	@Test
	public void parseTest(){

		 InputStream input;
			//System.out.println("========================解析结果 begin=================================");
			//input = new FileInputStream("c:\\tmp\\CGN Lichuan CH PDD.pdf");
			//input = new FileInputStream(PddDownloader.SAVED_DIR+"20160517084329183440.pdf");
			//phaseOne.parseProjectBasicInfo(input);
			//System.out.println("========================解析结果 end=================================");
		
		 
	
	}
}
