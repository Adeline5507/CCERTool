package com.thomsonreuters.ccertools.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thomsonreuters.ccertool.dao.MethodologiesDao;
import com.thomsonreuters.ccertool.vo.MethodologiesVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MethodologiesDaoTest {
	@Autowired MethodologiesDao dao;
	@Test
	public void insertMethodologyTest(){
		MethodologiesVo vo = new MethodologiesVo();
		vo.setMethodologyName("adeline_test4");
		vo.setMethodologyDescription("desc");
		vo.setMethodologyCreated(new Date());
		vo.setMethodologyUpdated(new Date());
		Number num = dao.insertMethodology(vo);
		System.out.println(num.intValue());
	}
}
