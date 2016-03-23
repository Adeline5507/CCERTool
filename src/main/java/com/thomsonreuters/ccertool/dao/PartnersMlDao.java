package com.thomsonreuters.ccertool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.vo.PartnersVo;

@Service
public class PartnersMlDao {

	@Autowired JdbcTemplate jdbcTemplate;
	public void insertPartner(final PartnersVo vo){
		final String sql = "insert into partners_ml values(?,?,?,?,?,?)";
		//KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, vo.getPartnerId());
				ps.setString(2, vo.getPartnerName());
				ps.setString(3, vo.getPartnerAddress());
				ps.setString(4, vo.getPartnerNotes());
				ps.setString(5, vo.getPartnerLocation());
				ps.setInt(6, DaoConstants.CHINESE_LANG_ID);
				return ps;
			}
			
			});		
		//return null;
		//return keyHolder.getKey();
	}

}
