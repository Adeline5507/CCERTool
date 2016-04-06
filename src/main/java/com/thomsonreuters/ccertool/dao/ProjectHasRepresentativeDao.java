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

import com.thomsonreuters.ccertool.vo.ProjectHasRepresentativeVo;
@Service
public class ProjectHasRepresentativeDao {

	@Autowired JdbcTemplate jdbcTemplate;
	public void insertProjectHasRepresentative(final ProjectHasRepresentativeVo vo){
		final String sql = "insert into PROJECT_HAS_REPRESENTATIVE values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, vo.getProjectId());
				ps.setInt(2, vo.getRepresentativeId());
				ps.setInt(3, vo.getRepresentativeRoleId());
				return ps;
			}
			
			},keyHolder);		
		
	}

}
