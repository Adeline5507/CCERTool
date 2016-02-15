import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.parse.ParsePhaseThree;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ParsePhaseThreeTest {
	ParsePhaseThree phaseThree = new ParsePhaseThree();
	@Test
	public void parseTest(){

		 InputStream input;
		try {
			System.out.println("========================解析结果 begin=================================");
			input = new FileInputStream("C:\\Users\\U6036058\\Documents\\workfiles\\Task\\CCER-HONGLIANG\\芜湖海螺水泥有限公司218MW余热发电工程-检测报告.pdf");
			phaseThree.parseProjectInfo(input);
			System.out.println("========================解析结果 end=================================");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  	
	
	}
}
