package com.thomsonreuters.ccertool.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParsePDF {
	
	private static final Logger log = LoggerFactory.getLogger(ParsePDF.class);

	public static void main(String[] args){
		 InputStream input;
		try {
			input = new FileInputStream("C:\\Users\\U6036058\\Documents\\workfiles\\Task\\CCER-HONGLIANG\\芜湖海螺水泥有限公司218MW余热发电工程.pdf");
			parseProjectBasicInfo(input);
			
			
			
			/*System.out.println(s.getText(document));
			s.writeText(document, new OutputStreamWriter(new FileOutputStream("C:\\Users\\U6036058\\Documents\\workfiles\\Task\\CCER-HONGLIANG\\芜湖海螺水泥有限公司218MW余热发电工程.txt")));*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public static void parseProjectBasicInfo(InputStream in){
		try {
			PDDocument doc = PDDocument.load(in);
			PDFTextStripper s = new PDFTextStripper();
			s.setStartPage(1);
			//s.setEndPage(2);
			s.setLineSeparator("\n");
			String info = s.getText(doc);
			//log.info(info);
			//项目活动名称
			String pName = replaceLinebreak(findByRegEx("PROJECT_NAME",ParsePDFRegEx.PROJECT_NAME.getRegEx(),info));
			
			//项目文件完成日期
			String ppdCompleteDate = findByRegEx("PPD_COMPLETE_DATE",ParsePDFRegEx.PPD_COMPLETE_DATE.getRegEx(),info);

//			项目类别	project_category
			String projectCategory = findByRegEx("PROJECT_CATEGORY", ParsePDFRegEx.PROJECT_CATEGORY.getRegEx(), info);
			
//			CDM注册号	cdm_id
			String cdmId = findByRegEx("CDM_ID", ParsePDFRegEx.CDM_ID.getRegEx(), info);
			
//			项目业主	project_developer
			String projectDeveloper = findByRegEx("PROJECT_DEVELOPER", ParsePDFRegEx.PROJECT_DEVELOPER.getRegEx(), info);
			
//			项目类型	project_type
			String projectType = findByRegEx("PROJECT_TYPE", ParsePDFRegEx.PROJECT_TYPE.getRegEx(), info);
			
//			方法学	project_methodology
			String projectMethodology = findByRegEx("PROJECT_METHODOLOGY", ParsePDFRegEx.PROJECT_METHODOLOGY.getRegEx(), info);
			
//			预计的温室气体年均减排量	planned_annual_er
			String plannedAnnualEr = findByRegEx("PLANNED_ANNUAL_ER", ParsePDFRegEx.PLANNED_ANNUAL_ER.getRegEx(), info);
			
//			减排量起始日期	er_start_date
			String erStartDate = findByRegEx("ER_START_DATE", ParsePDFRegEx.ER_START_DATE.getRegEx(), info);
			
//			减排量截至日期	er_end_date
			String erEndDate = findByRegEx("ER_END_DATE", ParsePDFRegEx.ER_END_DATE.getRegEx(), info);

//			项目活动地点-省	project_location_state
			String projectLocationState = findByRegEx("PROJECT_LOCATION_STATE", ParsePDFRegEx.PROJECT_LOCATION_STATE.getRegEx(), info);
			
//			项目地理位置-东经	longitude
			String logitude = findByRegEx("LONGITUDE", ParsePDFRegEx.LONGITUDE.getRegEx(), info);
			
//			项目地理位置-北纬	latitude
			String latitude = findByRegEx("LATITUDE", ParsePDFRegEx.LATITUDE.getRegEx(), info);
			
//			项目总装机容量	installed_capacity
			String installedCapacity = findByRegEx("INSTALLED_CAPACITY", ParsePDFRegEx.INSTALLED_CAPACITY.getRegEx(), info);
//			年发电量	annual_electricity_production
			String annualElectricityProduction = findByRegEx("ANNUAL_ELECTRICITY_PRODUCTION", ParsePDFRegEx.ANNUAL_ELECTRICITY_PRODUCTION.getRegEx(), info);
//			项目总投资	project_investment
			String projectInvestment = findByRegEx("PROJECT_INVESTMENT", ParsePDFRegEx.PROJECT_INVESTMENT.getRegEx(), info);
			
//			企业法人地址	project_host_address
			String projectHostAddress = findByRegEx("PROJECT_HOST_ADDRESS", ParsePDFRegEx.PROJECT_HOST_ADDRESS.getRegEx(), info);
//			邮政编码	project_host_zip
			String projectHostZip =  findByRegEx("PROJECT_HOST_ZIP", ParsePDFRegEx.PROJECT_HOST_ZIP.getRegEx(), info);
//			电话	project_host_PHONE
			String projectHostPhone = findByRegEx("PROJECT_HOST_PHONE", ParsePDFRegEx.PROJECT_HOST_PHONE.getRegEx(), info);
//			传真	project_host_FAX
			String projectHostFax = findByRegEx("PROJECT_HOST_FAX", ParsePDFRegEx.PROJECT_HOST_FAX.getRegEx(), info);
//			电子邮件	project_host_EMAIL
			String projectHostEmail = findByRegEx("PROJECT_HOST_EMAIL", ParsePDFRegEx.PROJECT_HOST_EMAIL.getRegEx(), info);
//			网址	project_host_url
			String projectHostUrl = findByRegEx("PROJECT_HOST_URL", ParsePDFRegEx.PROJECT_HOST_URL.getRegEx(), info);
//			授权代表	REPRESENTATIVE_NAME
			String representaiveName = findByRegEx("REPRESENTATIVE_NAME", ParsePDFRegEx.REPRESENTATIVE_NAME.getRegEx(), info);
//			职务	REPRESENTATIVE_TITLE
			String representaiveTitle = findByRegEx("REPRESENTATIVE_TITLE", ParsePDFRegEx.REPRESENTATIVE_TITLE.getRegEx(), info);
//			电话	REPRESENTATIVE_phone
			String representaivePhone = findByRegEx("REPRESENTATIVE_PHONE", ParsePDFRegEx.REPRESENTATIVE_PHONE.getRegEx(), info);
//			传真	REPRESENTATIVE_fax
			String representaiveFax = findByRegEx("REPRESENTATIVE_FAX", ParsePDFRegEx.REPRESENTATIVE_FAX.getRegEx(), info);
//			电子邮件	REPRESENTATIVE_email
			String representaiveEmail = findByRegEx("REPRESENTATIVE_EMAIL", ParsePDFRegEx.REPRESENTATIVE_EMAIL.getRegEx(), info);

			//			unfccc_url	unfccc_url

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * 替换掉不需要的换行符
	 * @param str 原字符串，可能包含换行符
	 * @return
	 */
	public static String replaceLinebreak(String str){
		return str.replaceAll("\\s", "");
	} 
	/**
	 * 根据正则表达式匹配并返回匹配值
	 * @param regName
	 * @param reg
	 * @param info
	 * @return
	 */
	public static String findByRegEx(String regName,String reg,String info){
		//log.info("reg:"+reg);
		Pattern pattern = Pattern.compile(reg,Pattern.UNIX_LINES);
		Matcher matcher = pattern.matcher(info);
		String value="";
		if(matcher.find()){
			int c = matcher.groupCount();
			for(int i=1;i<=c;i++){
				value +=  matcher.group(i);
			}
			
			log.info(regName+":"+value);
		}else{
			log.error(regName+" not found");
		}
		
		return value;
	}
}
