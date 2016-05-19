package com.thomsonreuters.ccertools.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.service.PhaseThreeService;
import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class PhaseThreeServiceTest {
	@Autowired PhaseThreeService service;

	@Test
	public void monitorFileLoadAndParseInMemeoryTest() throws Exception{
//		ProjectDocumentVo vo = new ProjectDocumentVo();
//		vo.setProjectId(18084);
//		vo.setProjectDocumentTypeId(9);
//		service.monitorFileLoadAndParseInMemeory(vo);
	}
}
