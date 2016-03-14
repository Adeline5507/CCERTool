package com.thomsonreuters.ccertool.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.thomsonreuters.ccertool.vo.ProjectDocumentVo;
@Service
public class ProjectDocumentDao {
	private static final Logger log = LoggerFactory.getLogger(ProjectDocumentDao.class);
	private @Autowired DriverManagerDataSource dataSource;
	private @Autowired JdbcTemplate jdbcTemplate;
	/**
	 * 根据传入条件查询项目文件，保持到临时路径
	 * @param vo 查询条件
	 * @return 临时路径
	 * @throws Exception
	 */
	@Deprecated
	public String getProjectDocument(ProjectDocumentVo vo) throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String path=null;
		try {
			conn = dataSource.getConnection();
			log.info("connection get");
			String sql = "select * from project_documents where PROJECT_ID=? and PROJECT_DOCUMENT_TYPE_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getProjectId());
			ps.setInt(2, vo.getProjectDocumentTypeId());
			rs = ps.executeQuery();
			log.info("resultset is returned");
			if(rs.next()){
				String fileName = rs.getString("REPORT_FILE_NAME");
				path = "c:\\tmp\\"+fileName;
				BufferedInputStream bis = new BufferedInputStream(rs.getBlob("REPORT_FILE_CONTENT").getBinaryStream());
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
				byte[] buf = new byte[2048];
				int hasRead = 0;
				while((hasRead=bis.read(buf))>0){
					bos.write(buf, 0, hasRead);
				}
				bos.close();
				log.info("write to tmp is done");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		
		return path;
	}
	/**
	 * 根据传入条件查询项目文件,保存到字节数组
	 * @param vo 查询条件
	 * @return 保存了文件内容的字节数组
	 * @throws Exception
	 */
	public byte[] getProjectDocumentToMemory(ProjectDocumentVo vo) throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		byte[] bytes = null;
		try {
			conn = dataSource.getConnection();
			log.info("connection get");
			String sql = "select * from project_documents where PROJECT_ID=? and PROJECT_DOCUMENT_TYPE_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getProjectId());
			ps.setInt(2, vo.getProjectDocumentTypeId());
			rs = ps.executeQuery();
			log.info("resultset is returned");
			if(rs.next()){
				Blob b = rs.getBlob("REPORT_FILE_CONTENT");
				InputStream is = b.getBinaryStream();
				bytes = new byte[(int)b.length()];
				is.read(bytes);
				is.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		
		return bytes;
	}
	
	public List getDocumentsByProject(String projectId){
		String sql = "select project_id,report_file_name,project_document_type_id,PROJECT_DOCUMENT_ID from project_documents where project_id="+projectId;
		List rsList = jdbcTemplate.queryForList(sql);
		return rsList;
	}
	
	
	

}
