package com.thomsonreuters.ccertool.parse;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class ParsePhaseThree {
	private static final Logger log = LoggerFactory
			.getLogger(ParsePhaseThree.class);


	public void parseProjectInfo(InputStream in) throws IOException {
			PDDocument doc = PDDocument.load(in);
			PDFTextStripper s = new PDFTextStripper();
			s.setStartPage(1);
			// s.setEndPage(2);
			s.setLineSeparator("\n");
			String info = s.getText(doc);
			//log.info(info);
//			项目活动备案编号	registration_number	
			String registrationNumber = ParseUtil.findByRegEx("REGISTRATION_NUMBER", ParsePDFRegEx.REGISTRATION_NUMBER.getRegEx(), info);
//			监测报告完成日期	mr_complete_date	
			String mrCompleteDate = ParseUtil.findByRegEx("MR_COMPLETE_DATE", ParsePDFRegEx.MR_COMPLETE_DATE.getRegEx(), info);
//			本监测期覆盖日期-起始日	er_start_date	
			String erStartDate = ParseUtil.findByRegEx("ER_START_DATE_phase3", ParsePDFRegEx.ER_START_DATE_phase3.getRegEx(), info);
//			本监测期覆盖日期-截止日	er_end_date	
			String erEndDate = ParseUtil.findByRegEx("ER_END_DATE_phase3", ParsePDFRegEx.ER_END_DATE_phase3.getRegEx(), info);
//			项目设计文件中预估的本监测期内温室气体减排量或人为净碳汇量	er_planned_volume	
			String erPlannedVolume = ParseUtil.findByRegEx("ER_PLANNED_VOLUME", ParsePDFRegEx.ER_PLANNED_VOLUME.getRegEx(), info);
//			本监测期内实际的温室气体减排量或人为净碳汇量	er_monitor_volume	
			String erMonitorVolume = ParseUtil.findByRegEx("ER_MONITOR_VOLUME", ParsePDFRegEx.ER_MONITOR_VOLUME.getRegEx(), info);

			
		
}

}