package com.thomsonreuters.ccertool.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;


@Service
public class ProjectsDao {
	private static final Logger log = LoggerFactory.getLogger(ProjectsDao.class);
	private @Autowired JdbcTemplate jdbcTemplate;
	
	public void searchProjectInfo(){
		String sql = "select count(*) from projects";
		jdbcTemplate.query(sql, new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				log.info(rs.getString(1));
			}
			
		});
		
		
	}
	
	
	
}
