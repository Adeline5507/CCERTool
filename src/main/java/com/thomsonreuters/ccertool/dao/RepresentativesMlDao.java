package com.thomsonreuters.ccertool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.vo.RepresentativesVo;
@Service
public class RepresentativesMlDao {

	@Autowired JdbcTemplate jdbcTemplate;
	public void insertRepresentative(final RepresentativesVo vo){
		final String sql = "insert into representatives_ml values(?,?,?,?,?,?,?,?,?)";
		//KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, vo.getRepresentativeId());
				ps.setString(2, vo.getRepresentativeName());
				ps.setString(3, vo.getRepresentativeTitle());
				ps.setString(4, vo.getRepresentativePhone());
				ps.setString(5, vo.getRepresentativeEmail());
				ps.setString(6, vo.getRepresentativeNotes());
				ps.setString(7, vo.getRepresentativeAddress());
				ps.setString(8, vo.getRepresentativeFax());
				ps.setInt(9, DaoConstants.CHINESE_LANG_ID);
				
				return ps;
			}
			
			});		
		//return null;
		//return keyHolder.getKey();
	}

}
