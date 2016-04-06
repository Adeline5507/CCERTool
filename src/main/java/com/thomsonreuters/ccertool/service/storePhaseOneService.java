package com.thomsonreuters.ccertool.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.dao.MethodologiesDao;
import com.thomsonreuters.ccertool.dao.PartnersDao;
import com.thomsonreuters.ccertool.dao.PartnersMlDao;
import com.thomsonreuters.ccertool.dao.ProjectCategoriesDao;
import com.thomsonreuters.ccertool.dao.ProjectHasRepresentativeDao;
import com.thomsonreuters.ccertool.dao.ProjectTypeDao;
import com.thomsonreuters.ccertool.dao.ProjectsDao;
import com.thomsonreuters.ccertool.dao.RepresentativesDao;
import com.thomsonreuters.ccertool.dao.RepresentativesMlDao;
import com.thomsonreuters.ccertool.vo.MethodologiesVo;
import com.thomsonreuters.ccertool.vo.PartnersVo;
import com.thomsonreuters.ccertool.vo.ProjectCategoriesVo;
import com.thomsonreuters.ccertool.vo.ProjectHasRepresentativeVo;
import com.thomsonreuters.ccertool.vo.ProjectTypeVo;
import com.thomsonreuters.ccertool.vo.ProjectVo;
import com.thomsonreuters.ccertool.vo.RepresentativesVo;

@Service
public class storePhaseOneService {
	
	private @Autowired ProjectCategoriesDao projectCategoriesDao;
	private @Autowired ProjectTypeDao projectTypeDao;
	private @Autowired MethodologiesDao methodologiesDao;
	private @Autowired PartnersDao partnersDao;
	private @Autowired PartnersMlDao partnersMlDao;
	private @Autowired RepresentativesDao representativesDao;
	private @Autowired RepresentativesMlDao representativesMlDao;
	private @Autowired ProjectHasRepresentativeDao projectHasRepresentativeDao;
	private @Autowired ProjectsDao projectsDao;
	
	private ProjectCategoriesVo projectCategoriesVo;
	private ProjectTypeVo projectTypeVo;
	private MethodologiesVo methodologiesVo;
	private PartnersVo partnersVo;
	private PartnersVo partnersMlVo;
	private RepresentativesVo representativesVo;
	private RepresentativesVo RepresentativesMlVo;
	private ProjectHasRepresentativeVo projectHasRepresentativeVo;
	private ProjectVo projectVo;
	/**
	 * 把解析的内容存库
	 * @param map
	 */
	public void storeInfo(int projectId,Map<String,String> map){

		projectCategoriesVo = new ProjectCategoriesVo();
		projectCategoriesVo.setName(map.get("PROJECT_CATEGORY"));
		projectCategoriesVo.setDescription(map.get("PROJECT_CATEGORY"));
		Number projectCategoryId = projectCategoriesDao.insertProjectCategory(projectCategoriesVo);
		
		projectTypeVo = new ProjectTypeVo();
		//TODO projectTypeVo
		Number projectTypeId = projectTypeDao.insertProjectType(projectTypeVo);
		
		methodologiesVo = new MethodologiesVo();
		methodologiesVo.setMethodologyName(map.get("PROJECT_METHODOLOGY"));
		methodologiesVo.setMethodologyCreated(new Date());
		Number methodologyId = methodologiesDao.insertMethodology(methodologiesVo);
		
		partnersVo = new PartnersVo();
		partnersVo.setPartnerName(map.get("PROJECT_DEVELOPER"));
		partnersVo.setPartnerAddress(map.get("PROJECT_HOST_ADDRESS"));
		partnersVo.setPartnerEmail(map.get("PROJECT_HOST_EMAIL"));
		partnersVo.setPartnerZip(map.get("PROJECT_HOST_ZIP"));
		partnersVo.setPartnerFax(map.get("PROJECT_HOST_FAX"));
		partnersVo.setPartnerPhone(map.get("PROJECT_HOST_PHONE"));
		partnersVo.setPartnerUrl(map.get("PROJECT_HOST_URL"));
		partnersVo.setRepresentativeRoleId(26);
		Number partnerId = partnersDao.insertPartner(partnersVo);
		
		partnersMlVo = new PartnersVo();
		partnersMlVo.setPartnerId(partnerId.intValue());
		partnersMlVo.setPartnerName(map.get("PROJECT_DEVELOPER"));
		partnersMlVo.setPartnerAddress(map.get("PROJECT_HOST_ADDRESS"));
		partnersMlDao.insertPartner(partnersMlVo);
		
		representativesVo = new RepresentativesVo();
		representativesVo.setPartnerId(partnerId.intValue());
		representativesVo.setRepresentativeName(map.get("REPRESENTATIVE_NAME"));
		representativesVo.setRepresentativeTitle(map.get("REPRESENTATIVE_TITLE"));
		representativesVo.setRepresentativePhone(map.get("REPRESENTATIVE_PHONE"));
		representativesVo.setRepresentativeFax(map.get("REPRESENTATIVE_FAX"));
		representativesVo.setRepresentativeEmail(map.get("REPRESENTATIVE_EMAIL"));
		Number representativeId = representativesDao.insertRepresentative(representativesVo);
		
		RepresentativesMlVo = new RepresentativesVo();
		RepresentativesMlVo.setRepresentativeId(representativeId.intValue());
		RepresentativesMlVo.setRepresentativeName(map.get("REPRESENTATIVE_NAME"));
		RepresentativesMlVo.setRepresentativeTitle(map.get("REPRESENTATIVE_TITLE"));
		RepresentativesMlVo.setRepresentativePhone(map.get("REPRESENTATIVE_PHONE"));
		RepresentativesMlVo.setRepresentativeEmail(map.get("REPRESENTATIVE_EMAIL"));
		representativesMlDao.insertRepresentative(RepresentativesMlVo);
		
		projectVo = new ProjectVo();
		projectVo.setProjectId(projectId);
		projectVo.setProjectName(map.get("PROJECT_NAME"));
		projectVo.setProjectCategoryId(projectCategoryId.intValue());
		projectVo.setProjectApprovalDate(map.get("PPD_COMPLETE_DATE"));
		projectVo.setCmdId(map.get("CDM_ID"));
		projectVo.setProjectTypeId(projectTypeId.intValue());
		projectVo.setMethodologyId(methodologyId.intValue());
		projectVo.setPlannedAnnualEr(map.get("PLANNED_ANNUAL_ER"));
		projectVo.setProjectStartDate(map.get("ER_START_DATE"));
		projectVo.setProjectEndDate(map.get("ER_END_DATE"));
		projectVo.setProjectLocation(map.get("PROJECT_LOCATION_STATE"));
		projectVo.setLatitude(map.get("LATITUDE"));
		projectVo.setLongitude(map.get("LONGITUDE"));
		projectVo.setProjectPlannedCapacity(map.get("INSTALLED_CAPACITY"));
		projectVo.setProjectCapacityComment(map.get("ANNUAL_ELECTRICITY_PRODUCTION"));
		projectVo.setProjectInvestorComment(map.get("PROJECT_INVESTMENT"));
		projectsDao.updateProjectInfo(projectVo);
		
		projectHasRepresentativeVo= new ProjectHasRepresentativeVo();
		projectHasRepresentativeVo.setProjectId(projectId);
		projectHasRepresentativeVo.setRepresentativeId(representativeId.intValue());
		projectHasRepresentativeVo.setRepresentativeRoleId(26);
		
		
	

	}
	
	
}
