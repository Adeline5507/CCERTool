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

import com.thomsonreuters.ccertool.vo.ProjectTypeVo;

@Service
public class ProjectTypeDao {
	@Autowired JdbcTemplate jdbcTemplate;
	public Number insertProjectType(final ProjectTypeVo vo){

		final String sql = "insert into project_types values(project_types_seq.Nextval,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"PROJECT_TYPE_ID"});
				ps.setInt(1, vo.getProjectParentTypeId());
				ps.setString(2, vo.getProjectTypeName());
				return ps;
			}
			
			},keyHolder);		
		//return null;
		return keyHolder.getKey();
	
	}
	
}
