package com.thomsonreuters.ccertools.dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.dao.ProjectsDao;
import com.thomsonreuters.ccertool.vo.ProjectVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProjectsDaoTest {
	@Autowired
	private ProjectsDao dao;
	@Test
	public void searchProjectInfoTest(){
		dao.searchProjectInfo(new ProjectVo());
	}
}
