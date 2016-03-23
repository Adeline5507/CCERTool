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
	/**
	 * 根据解析内容更新项目信息（projects表）
	 * @param vo
	 * @return
	 */
	public int updateProjectInfo(ProjectVo vo){
		StringBuffer sb = new StringBuffer("update projects set ");
		if(vo.getProjectCategoryId()!=-1){//-1表示为空
			sb.append("PROJECT_CATEGORY_ID=").append(vo.getProjectCategoryId()).append(",");
		}
		if(vo.getProjectApprovalDate()!=null){
			sb.append("PROJECT_APPROVAL_DATE=").append(vo.getProjectApprovalDate()).append(",");
		}
		if(vo.getCmdId()!=null){
			sb.append("cdm_id=").append(vo.getCmdId()).append(",");
		}
		if(vo.getProjectTypeId()!=-1){
			sb.append("PROJECT_TYPE_ID='").append(vo.getProjectTypeId()).append("',");
		}
		if(vo.getMethodologyId()!=-1){
			sb.append("METHODOLOGY_ID=").append(vo.getMethodologyId()).append(",");
		}
		if(vo.getPlannedAnnualEr()!=null){
			sb.append("planned_annual_er=").append(vo.getPlannedAnnualEr()).append(",");
		}
		if(vo.getProjectStartDate()!=null){
			sb.append("PROJECT_START_DATE=").append(vo.getProjectStartDate()).append(",");
		}
		if(vo.getProjectEndDate()!=null){
			sb.append("PROJECT_END_DATE=").append(vo.getProjectEndDate()).append(",");
		}
		if(vo.getProjectLocation()!=null){
			sb.append("PROJECT_LOCATION='").append(vo.getProjectLocation()).append("',");
		}
		if(vo.getLatitude()!=null){
			sb.append("LATITUDE=").append(vo.getLatitude()).append(",");
		}
		if(vo.getLongitude()!=null){
			sb.append("LONGITUDE=").append(vo.getLongitude()).append(",");
		}
		
		if(vo.getProjectPlannedCapacity()!=-1){
			sb.append("PROJECT_PLANNED_CAPACITY=").append(vo.getProjectPlannedCapacity()).append(",");
		}
		
		if(vo.getProjectCapacityComment()!=null){
			sb.append("PROJECT_CAPACITY_COMMENT='").append(vo.getProjectCapacityComment()).append("',");
		}
		if(vo.getProjectInvestorComment()!=null){
			sb.append("PROJECT_INVESTOR_COMMENT='").append(vo.getProjectInvestorComment()).append("'");
		}
		
		String updatePre = sb.toString();
		if(updatePre.endsWith(",")){
			updatePre = updatePre.substring(0,updatePre.length()-1);
		}
		
		String sql = updatePre+" where project_id="+vo.getProductId();
		log.info("sql:"+sql);
		return jdbcTemplate.update(sql);
	} 
	
	
}
