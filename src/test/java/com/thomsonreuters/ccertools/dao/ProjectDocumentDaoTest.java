package com.thomsonreuters.ccertools.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.dao.ProjectDocumentDao;
import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProjectDocumentDaoTest {
	@Autowired
	private ProjectDocumentDao dao;
	@Test
	public void getProjectDocumentTest() throws Exception{
//		ProjectDocumentVo vo = new ProjectDocumentVo();
//		vo.setProjectDocumentId(2005);
//		dao.getProjectDocument(vo);
	}
	
}
