import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.parse.ParsePhaseOne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ParsePhaseTwoTest {
	ParsePhaseOne phaseOne = new ParsePhaseOne();
	@Test
	public void parseTest(){

		 InputStream input;
		try {
			input = new FileInputStream("C:\\Users\\U6036058\\Documents\\workfiles\\Task\\CCER-HONGLIANG\\芜湖海螺水泥有限公司218MW余热发电工程.pdf");
			phaseOne.parseProjectBasicInfo(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	
	}
}
