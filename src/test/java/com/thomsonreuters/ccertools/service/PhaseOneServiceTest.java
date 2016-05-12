package com.thomsonreuters.ccertools.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.service.PhaseOneService;
import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PhaseOneServiceTest {
	@Autowired PhaseOneService service;
	private @Value("${testValue:true}") boolean test;
//	@Test
//	public void pddLoadAndParseTest() throws Exception{
//		ProjectDocumentVo vo = new ProjectDocumentVo();
//		//vo.setProjectDocumentId(24553);
//		vo.setProjectId(18084);
//		vo.setProjectDocumentTypeId(8);
//		service.pddLoadAndParse(vo);
//		
//	}
	@Test
	public void pddLoadAndParseInMemoryTest() throws Exception{
		ProjectDocumentVo vo = new ProjectDocumentVo();
		vo.setProjectId(18084);
		vo.setProjectDocumentTypeId(8);
		service.pddLoadAndParseInMemory(vo);
		
	}
	@Test
	public void booleanValueTest(){
		if(test){
			System.out.println("test is true");
		}else{
			System.out.println("test is false");
		}
	}
}
