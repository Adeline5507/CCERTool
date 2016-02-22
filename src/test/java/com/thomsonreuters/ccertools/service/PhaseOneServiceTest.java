package com.thomsonreuters.ccertools.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.service.PhaseOneService;
import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PhaseOneServiceTest {
	@Autowired PhaseOneService service;
	@Test
	public void pddLoadAndParseTest() throws Exception{
		ProjectDocumentVo vo = new ProjectDocumentVo();
		vo.setProjectDocumentId(24553);
		service.pddLoadAndParse(vo);
		
	}
	@Test
	public void pddLoadAndParseInMemoryTest() throws Exception{
		ProjectDocumentVo vo = new ProjectDocumentVo();
		vo.setProjectDocumentId(24553);
		service.pddLoadAndParseInMemory(vo);
		
	}
}