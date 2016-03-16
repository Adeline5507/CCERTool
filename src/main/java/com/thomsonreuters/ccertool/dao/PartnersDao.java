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

import com.thomsonreuters.ccertool.vo.PartnersVo;

@Service
public class PartnersDao {
	@Autowired JdbcTemplate jdbcTemplate;
	public Number insertPartner(final PartnersVo vo){
		final String sql = "insert into partners values(partners_seq.Nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();  
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,new String[]{"PARTNER_ID"});
				ps.setInt(1, vo.getCountryStateId());
				ps.setString(2, vo.getPartnerName());
				ps.setString(3, vo.getPartnerPhone());
				ps.setString(4, vo.getPartnerFax());
				ps.setString(5, vo.getPartnerUrl());
				ps.setString(6, vo.getPartnerEmail());
				ps.setString(7, vo.getPartnerAddress());
				ps.setString(8, vo.getPartnerNotes());
				ps.setString(9, vo.getPartnerLocation());
				ps.setDate(10, new Date(vo.getPartnerCreated().getTime()));
				ps.setDate(11, new Date(vo.getPartnerUpdated().getTime()));
				ps.setString(12, vo.getPartnerZip());
				ps.setInt(13, vo.getVisibilityId());
				ps.setInt(14, vo.getRepresentativeRoleId());
				return ps;
			}
			
			},keyHolder);		
		//return null;
		return keyHolder.getKey();
	}
}
