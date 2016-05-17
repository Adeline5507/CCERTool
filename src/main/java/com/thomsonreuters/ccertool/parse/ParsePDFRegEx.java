package com.thomsonreuters.ccertool.parse;

public enum ParsePDFRegEx {
	/*项目活动名称	project_name	PROJECTS_ML,PROJECTS
	项目类别	project_category	PROJECTS
	项目文件完成日期	ppd_complete_date	
	CDM注册号	cdm_id	cdm_id
	项目业主	project_developer	
	项目类型	project_type	PROJECTS
	方法学	project_methodology	
	预计的温室气体年均减排量	planned_annual_er	PROJECTS
	减排量起始日期	er_start_date	
	减排量截至日期	er_end_date	*/


	/*项目活动地点-省	project_location_state	
	项目地理位置-东经	longitude	PROJECTS
	项目地理位置-北纬	latitude	PROJECTS*/

	/*项目活动的技术说明		
	项目总装机容量	36MW	installed_capacity
	年发电量	276,000MWh	annual_electricity_production
	项目总投资	262,730,800元	project_investment*/


	/*申请项目备案的企业法人联系信息				
	企业法人地址	安徽省芜湖市繁昌县繁阳镇	project_host_address		
	邮政编码	241000	project_host_zip		
	电话	0553 8396953	project_host_PHONE		
	传真	0553 8396954	project_host_FAX		
	电子邮件	jszx-conch@163.com	project_host_EMAIL		
	网址		project_host_url		
	授权代表	黄丽萍	REPRESENTATIVE_NAME	REPRESENTATIVES_ML,REPRESENTATIVES	
	职务	项目经理	REPRESENTATIVE_TITLE	REPRESENTATIVES_ML,REPRESENTATIVES	
	电话	0553 8396953	REPRESENTATIVE_phone	REPRESENTATIVES_ML,REPRESENTATIVES	
	传真	0553 8396954	REPRESENTATIVE_fax	REPRESENTATIVES_ML,REPRESENTATIVES	
	电子邮件	jszx-conch@163.com	REPRESENTATIVE_email	REPRESENTATIVES_ML,REPRESENTATIVES	
	unfccc_url	http://cdm.unfccc.int/Projects/DB/TUEV-SUED1300286802.18/view	unfccc_url		
*/
	PROJECT_NAME("项目活动名称([\\s\\S]*?)\\s*\\n"),
	PROJECT_CATEGORY("项目类别2([\\s\\S]*?)\\s*\\n"),
	PPD_COMPLETE_DATE("项目设计文件完成日期([\\s\\S]*?)\\s*\\n"),//TODO 确认
	CDM_ID("CDM[\\s*]注册号：|CDM 注册号([\\s\\S]*?)\\s"),
	PROJECT_DEVELOPER("项目业主([\\s\\S]*?)\\s*\\n"),
	PROJECT_TYPE("项目类型：|类别：([\\s\\S]*?)\\s*\\n"),
	//PROJECT_TYPE("项目类型：(?s)(.*?)"),
	PROJECT_METHODOLOGY("方法学：([\\s\\S]*?)\\s*\\n"),
	PLANNED_ANNUAL_ER("预计的温室气体减排量|年均减排量：([\\s\\S]*?)\\s*\\n"),
	ER_START_DATE("项目补充计入期:([\\s\\S]*?)~"),
	ER_END_DATE("项目补充计入期:[\\s\\S]*?~([\\s\\S]*?)\\s*\\n"),//TODO 有的文档里面没有，格式是否统一
	
	PROJECT_LOCATION_STATE("省/直辖市/自治区，等[\\s]*>>[\\s]*([\\s\\S]*?)\\s*\\n"),
//	LONGITUDE("东.*[\\s]*((\\d{1,2}|[1][0-7]\\d)[°](\\d|5\\d)[′](\\d|5\\d)[″])|(180°0′0″)"),
//	LATITUDE("北纬[\\s]*(((\\d|[1-8]\\d)[°](\\d|5\\d)[′](\\d|5\\d)[″])|(90°0′0″))"),
	LONGITUDE("东经[\\s]*([\\s\\S]*?)(\\s*)[，,。]"),
	LATITUDE("北纬[\\s]*([\\s\\S]*?)(\\s*)[，,。]"),
	INSTALLED_CAPACITY("总装机容量为\\s*(.*?MW)"),//TODO 多个，确认
	ANNUAL_ELECTRICITY_PRODUCTION("上网电量[为：]([\\s\\S]*?)MW"),//TODO 发电量，关键字不同，单位也不同，难以准确提取
	PROJECT_INVESTMENT("((总投资|静态投资|项目投资)([\\s\\S]*?)(元|万元))",3),//TODO 项目总投资，关键字不同，难以准确提取
	PROJECT_HOST_ADDRESS("申请项目备案的企业法人联系信息[\\s\\S]*地址：([\\s\\S]*?)\\s*\\n"),
	PROJECT_HOST_ZIP("申请项目备案的企业法人联系信息[\\s\\S]*邮政编码：([\\s\\S]*?)\\s*\\n"),
	PROJECT_HOST_PHONE("申请项目备案的企业法人联系信息[\\s\\S]*电话：([\\s\\S]*?)\\s*\\n"),
	PROJECT_HOST_FAX("申请项目备案的企业法人联系信息[\\s\\S]*传真：([\\s\\S]*?)\\s*\\n"),
	PROJECT_HOST_EMAIL("申请项目备案的企业法人联系信息[\\s\\S]*电子邮件：([\\s\\S]*?)\\s*\\n"),
	PROJECT_HOST_URL("申请项目备案的企业法人联系信息[\\s\\S]*网址：([\\s\\S]*?)\\s*\\n"),
	REPRESENTATIVE_NAME("申请项目备案的企业法人联系信息[\\s\\S]*姓名：([\\s\\S]*?)\\s*\\n"),
	REPRESENTATIVE_TITLE("申请项目备案的企业法人联系信息[\\s\\S]*职务：([\\s\\S]*?)\\s*\\n"),
	REPRESENTATIVE_PHONE("申请项目备案的企业法人联系信息[\\s\\S]*电话：([\\s\\S]*?)\\s*\\n"),
	REPRESENTATIVE_FAX("申请项目备案的企业法人联系信息[\\s\\S]*传真：([\\s\\S]*?)\\s*\\n"),
	REPRESENTATIVE_EMAIL("申请项目备案的企业法人联系信息[\\s\\S]*电子邮件：([\\s\\S]*?)\\s*\\n"),
	UNFCCC_URL(""),//TODO 不知是什么

	//phase three 检测报告
	
	REGISTRATION_NUMBER("项目活动备案编号([\\s\\S]*?)\\s*\\n"),//项目活动备案编号	
	MR_COMPLETE_DATE("监测报告的完成日期([\\s\\S]*?)\\s*\\n"),	//监测报告完成日期
	ER_START_DATE_phase3("补充计入期([\\s\\S]*?)-"),//本监测期覆盖日期-起始日	
	ER_END_DATE_phase3("补充计入期[\\s\\S]*?-([\\s\\S]*?)项目业主"),	//本监测期覆盖日期-截止日
	ER_PLANNED_VOLUME("项目设计文件中预估的[\\s\\S]*?人为净碳汇量([\\s\\S]*?)tCO2e"),	//项目设计文件中预估的本监测期内温室气体减排量或人为净碳汇量
	ER_MONITOR_VOLUME("本监测期内实际的[\\s\\S]*?人为净碳汇量([\\s\\S]*?)tCO2e");	//本监测期内实际的温室气体减排量或人为净碳汇量

	
	private String regEx;
	private  int groupIndex = 1;
	private ParsePDFRegEx(String regEx){
		this.regEx = regEx;
	}
	private ParsePDFRegEx(String regEx,int groupIndex){
		this.regEx = regEx;
		this.groupIndex = groupIndex;
	}
	public String getRegEx(){
		return regEx;
	}
	public int getGroupIndex(){
		return groupIndex;
	}
	
}
