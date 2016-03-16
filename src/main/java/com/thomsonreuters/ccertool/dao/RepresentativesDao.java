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

import com.thomsonreuters.ccertool.vo.RepresentativesVo;

@Service
public class RepresentativesDao {
	@Autowired JdbcTemplate jdbcTemplate;
	public Number insertRepresentative(final RepresentativesVo vo){
		final String sql = "insert into representatives values(representatives_seq.Nextval,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"REPRESENTATIVE_ID"});
				ps.setInt(1, vo.getPartnerId());
				ps.setString(2, vo.getRepresentativeName());
				ps.setString(3, vo.getRepresentativeTitle());
				ps.setString(4, vo.getRepresentativePhone());
				ps.setString(5, vo.getRepresentativeEmail());
				ps.setString(6, vo.getRepresentativeNotes());
				ps.setDate(7, new Date(vo.getRepresentativeCreated().getTime()));
				ps.setDate(8, new Date(vo.getRepresentativeUpdated().getTime()));
				ps.setString(9, vo.getRepresentativeAddress());
				ps.setString(10, vo.getRepresentativeFax());
				ps.setInt(11, vo.getVisibilityId());
				return ps;
			}
			
			},keyHolder);		
		//return null;
		return keyHolder.getKey();
	}
}
