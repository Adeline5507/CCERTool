package com.thomsonreuters.ccertool.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class ParsePhaseOne {

	private static final Logger log = LoggerFactory
			.getLogger(ParsePhaseOne.class);

	public static void main(String[] args) {
	}

	public Map parseProjectBasicInfo(InputStream in) throws IOException {
		Map map = new HashMap<String,String>();
		try {
			PDDocument doc = PDDocument.load(in);
			PDFTextStripper s = new PDFTextStripper();
			s.setStartPage(1);
			// s.setEndPage(2);
			s.setLineSeparator("\n");
			String info = s.getText(doc);
			
			 log.info(info);
			// 项目活动名称
			String pName = ParseUtil.findByRegEx("PROJECT_NAME",
					ParsePDFRegEx.PROJECT_NAME.getRegEx(), info,map);

			// 项目文件完成日期
			String ppdCompleteDate = ParseUtil.findByRegEx("PPD_COMPLETE_DATE",
					ParsePDFRegEx.PPD_COMPLETE_DATE.getRegEx(), info,map);

			// 项目类别 project_category
			String projectCategory = ParseUtil.findByRegEx("PROJECT_CATEGORY",
					ParsePDFRegEx.PROJECT_CATEGORY.getRegEx(), info,map);

			// CDM注册号 cdm_id
			String cdmId = ParseUtil.findByRegEx("CDM_ID",
					ParsePDFRegEx.CDM_ID.getRegEx(), info,map);

			// 项目业主 project_developer
			String projectDeveloper = ParseUtil.findByRegEx(
					"PROJECT_DEVELOPER",
					ParsePDFRegEx.PROJECT_DEVELOPER.getRegEx(), info,map);

			// 项目类型 project_type
			String projectType = ParseUtil.findByRegEx("PROJECT_TYPE",
					ParsePDFRegEx.PROJECT_TYPE.getRegEx(), info,map);

			// 方法学 project_methodology
			String projectMethodology = ParseUtil.findByRegEx(
					"PROJECT_METHODOLOGY",
					ParsePDFRegEx.PROJECT_METHODOLOGY.getRegEx(), info,map);

			// 预计的温室气体年均减排量 planned_annual_er
			String plannedAnnualEr = ParseUtil.findByRegEx("PLANNED_ANNUAL_ER",
					ParsePDFRegEx.PLANNED_ANNUAL_ER.getRegEx(), info,map);

			// 减排量起始日期 er_start_date
			String erStartDate = ParseUtil.findByRegEx("ER_START_DATE",
					ParsePDFRegEx.ER_START_DATE.getRegEx(), info,map);

			// 减排量截至日期 er_end_date
			String erEndDate = ParseUtil.findByRegEx("ER_END_DATE",
					ParsePDFRegEx.ER_END_DATE.getRegEx(), info,map);

			// 项目活动地点-省 project_location_state
			String projectLocationState = ParseUtil.findByRegEx(
					"PROJECT_LOCATION_STATE",
					ParsePDFRegEx.PROJECT_LOCATION_STATE.getRegEx(), info,map);

			// 项目地理位置-东经 longitude
			String logitude = ParseUtil.findByRegEx("LONGITUDE",
					ParsePDFRegEx.LONGITUDE.getRegEx(), info,map);

			// 项目地理位置-北纬 latitude
			String latitude = ParseUtil.findByRegEx("LATITUDE",
					ParsePDFRegEx.LATITUDE.getRegEx(), info,map);

			// 项目总装机容量 installed_capacity
			String installedCapacity = ParseUtil.findByRegEx(
					"INSTALLED_CAPACITY",
					ParsePDFRegEx.INSTALLED_CAPACITY.getRegEx(), info,map);

			// 年发电量 annual_electricity_production
			String annualElectricityProduction = ParseUtil.findByRegEx(
					"ANNUAL_ELECTRICITY_PRODUCTION",
					ParsePDFRegEx.ANNUAL_ELECTRICITY_PRODUCTION.getRegEx(),
					info,map);

			// 项目总投资 project_investment
			String projectInvestment = ParseUtil.findByRegEx(
					"PROJECT_INVESTMENT",
					ParsePDFRegEx.PROJECT_INVESTMENT.getRegEx(), info,
					ParsePDFRegEx.PROJECT_INVESTMENT.getGroupIndex(),map);

			// 企业法人地址 project_host_address
			String projectHostAddress = ParseUtil.findByRegEx(
					"PROJECT_HOST_ADDRESS",
					ParsePDFRegEx.PROJECT_HOST_ADDRESS.getRegEx(), info,map);

			// 邮政编码 project_host_zip
			String projectHostZip = ParseUtil.findByRegEx("PROJECT_HOST_ZIP",
					ParsePDFRegEx.PROJECT_HOST_ZIP.getRegEx(), info,map);

			// 电话 project_host_PHONE
			String projectHostPhone = ParseUtil.findByRegEx(
					"PROJECT_HOST_PHONE",
					ParsePDFRegEx.PROJECT_HOST_PHONE.getRegEx(), info,map);

			// 传真 project_host_FAX
			String projectHostFax = ParseUtil.findByRegEx("PROJECT_HOST_FAX",
					ParsePDFRegEx.PROJECT_HOST_FAX.getRegEx(), info,map);

			// 电子邮件 project_host_EMAIL
			String projectHostEmail = ParseUtil.findByRegEx(
					"PROJECT_HOST_EMAIL",
					ParsePDFRegEx.PROJECT_HOST_EMAIL.getRegEx(), info,map);

			// 网址 project_host_url
			String projectHostUrl = ParseUtil.findByRegEx("PROJECT_HOST_URL",
					ParsePDFRegEx.PROJECT_HOST_URL.getRegEx(), info,map);

			// 授权代表 REPRESENTATIVE_NAME
			String representaiveName = ParseUtil.findByRegEx(
					"REPRESENTATIVE_NAME",
					ParsePDFRegEx.REPRESENTATIVE_NAME.getRegEx(), info,map);

			// 职务 REPRESENTATIVE_TITLE
			String representaiveTitle = ParseUtil.findByRegEx(
					"REPRESENTATIVE_TITLE",
					ParsePDFRegEx.REPRESENTATIVE_TITLE.getRegEx(), info,map);

			// 电话 REPRESENTATIVE_phone
			String representaivePhone = ParseUtil.findByRegEx(
					"REPRESENTATIVE_PHONE",
					ParsePDFRegEx.REPRESENTATIVE_PHONE.getRegEx(), info,map);

			// 传真 REPRESENTATIVE_fax
			String representaiveFax = ParseUtil.findByRegEx(
					"REPRESENTATIVE_FAX",
					ParsePDFRegEx.REPRESENTATIVE_FAX.getRegEx(), info,map);

			// 电子邮件 REPRESENTATIVE_email
			String representaiveEmail = ParseUtil.findByRegEx(
					"REPRESENTATIVE_EMAIL",
					ParsePDFRegEx.REPRESENTATIVE_EMAIL.getRegEx(), info,map);

			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			in.close();
		}
		
		return map;
	}

}
