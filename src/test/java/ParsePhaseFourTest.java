
import java.io.IOException;

import org.htmlparser.util.ParserException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.parse.ParsePhaseFour;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ParsePhaseFourTest {
	ParsePhaseFour phaseFour = new ParsePhaseFour();
	@Test
	public void parseTest() throws ParserException, IOException{
		System.out.println("========================解析结果 begin=================================");
		phaseFour.parseInfo("http://cdm.ccchina.gov.cn/zyDetail.aspx?newsId=50828&TId=169");
		System.out.println("========================解析结果 end=================================");
	}
}
