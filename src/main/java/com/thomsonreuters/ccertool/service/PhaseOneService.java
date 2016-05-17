package com.thomsonreuters.ccertool.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.dao.ProjectDocumentDao;
import com.thomsonreuters.ccertool.downloader.PddDownloader;
import com.thomsonreuters.ccertool.parse.ParsePhaseOne;
import com.thomsonreuters.ccertool.parse.ParseUtil;
import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;
@Service
public class PhaseOneService {
	private static final Logger log = LoggerFactory.getLogger(PhaseOneService.class);  
	@Autowired
	ProjectDocumentDao dao;
	@Autowired
	ParsePhaseOne parser;
	@Deprecated
	public void pddLoadAndParse(ProjectDocumentVo vo) throws Exception{
		log.info("PhaseOneService begin");
		String path = dao.getProjectDocument(vo);
		log.info("PhaseOneService get document finished");
		parser.parseProjectBasicInfo(new FileInputStream(path));
		log.info("PhaseOneService parse finished");
		ParseUtil.removeTmpFile(path);
		log.info("PhaseOneService delete tmp document finished");
	}
	
	public Map pddLoadAndParseInMemory(ProjectDocumentVo vo) throws Exception{
		log.info("PhaseOneService begin");
		byte[] bytes = dao.getProjectDocumentToMemory(vo);
		log.info("PhaseOneService get document in memory finished");
		Map map = parser.parseProjectBasicInfo(new ByteArrayInputStream(bytes));
		log.info("PhaseOneService parse finished");
		return map;
	}
	
	public Map pddParse(String name) throws Exception{
		log.info("pddParse begin");
		Map map = parser.parseProjectBasicInfo(new FileInputStream(PddDownloader.SAVED_DIR+name));
		log.info("pddParse finished");
		return map;
	}

}
