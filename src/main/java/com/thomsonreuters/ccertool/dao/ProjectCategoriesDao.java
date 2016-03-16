package com.thomsonreuters.ccertool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.vo.ProjectCategoriesVo;

@Service
public class ProjectCategoriesDao {
	@Autowired JdbcTemplate jdbcTemplate;
	public Number insertProjectCategory(final ProjectCategoriesVo vo){
		final String sql = "insert into project_categories values(project_categories_seq.Nextval,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"PROJECT_CATEGORY_ID"});
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getDescription());
				return ps;
			}
			
			},keyHolder);		
		//return null;
		return keyHolder.getKey();
	
	
	}
}
