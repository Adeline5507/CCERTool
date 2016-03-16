package com.thomsonreuters.ccertool.service;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.dao.ProjectDocumentDao;
import com.thomsonreuters.ccertool.parse.ParsePhaseThree;
import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;
@Service
public class PhaseThreeService {
	
	private static final Logger log = LoggerFactory.getLogger(PhaseThreeService.class);  
	@Autowired
	ProjectDocumentDao dao;
	@Autowired
	ParsePhaseThree parser;
	
	public Map monitorFileLoadAndParseInMemeory(ProjectDocumentVo vo) throws Exception{
		Map map = null;
		log.info("PhaseThreeService begin");
		byte[] bytes = dao.getProjectDocumentToMemory(vo);
		log.info("PhaseThreeService get document in memory finished");
		map = parser.parseProjectInfo(new ByteArrayInputStream(bytes));
		log.info("PhaseThreeService parse finished");
		return map;
	}

}
