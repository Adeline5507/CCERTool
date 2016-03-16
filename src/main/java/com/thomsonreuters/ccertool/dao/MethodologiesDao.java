package com.thomsonreuters.ccertool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.vo.MethodologiesVo;
@Service
public class MethodologiesDao {
	@Autowired JdbcTemplate jdbcTemplate;

	public Number insertMethodology(final MethodologiesVo vo){
		final String sql = "insert into methodologies values(methodologies_seq.Nextval,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"METHODOLOGY_ID"});
				//ps.setInt(1, vo.getMethodologyId());
				ps.setString(1, vo.getMethodologyName());
				ps.setString(2, vo.getMethodologyDescription());
				ps.setDate(3, new Date(vo.getMethodologyCreated().getTime()));
				ps.setDate(4, new Date(vo.getMethodologyUpdated().getTime()));
				ps.setString(5, vo.getMethodologySource());
				return ps;
			}
			
			},keyHolder);		
		//return null;
		return keyHolder.getKey();
	}
}
