package com.thomsonreuters.ccertool.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.vo.ProjectVo;


@Service
public class ProjectsDao {
	private static final Logger log = LoggerFactory.getLogger(ProjectsDao.class);
	private @Autowired JdbcTemplate jdbcTemplate;
	
	/**
	 * 查询所有中国项目
	 * @return
	 */
	public List searchProjectInfo(ProjectVo vo){
		String sql = "select project_id,project_name,COUNTRY_STATE_ID,project_location from projects where market_id = 19";
		if(vo.getProjectName()!=null && !vo.getProjectName().equals("")){
			sql +=" and project_name like '%"+vo.getProjectName()+"%'";
		}
		List rsList = jdbcTemplate.queryForList(sql);
		return rsList;
	}
	
	public void updateProjectInfo(ProjectVo vo){
		String sql = "update projects ";
	}
	
	
}
