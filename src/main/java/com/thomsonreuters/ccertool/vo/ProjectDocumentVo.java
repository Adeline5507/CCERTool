package com.thomsonreuters.ccertool.vo;

import java.io.InputStream;

public class ProjectDocumentVo {
    
    private int projectDocumentId;

    
    private int projectId;

    
    private String reportFileName;

    
    private String reportFileContentType;

    
    private int projectDocumentTypeId;

    
    private InputStream reportFileContent;

    
    public int getProjectDocumentId() {
        return projectDocumentId;
    }

    
    public void setProjectDocumentId(int projectDocumentId) {
        this.projectDocumentId = projectDocumentId;
    }

    
    public int getProjectId() {
        return projectId;
    }

    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    
    public String getReportFileName() {
        return reportFileName;
    }

    
    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    
    public String getReportFileContentType() {
        return reportFileContentType;
    }

    
    public void setReportFileContentType(String reportFileContentType) {
        this.reportFileContentType = reportFileContentType;
    }

    
    public int getProjectDocumentTypeId() {
        return projectDocumentTypeId;
    }

    
    public void setProjectDocumentTypeId(int projectDocumentTypeId) {
        this.projectDocumentTypeId = projectDocumentTypeId;
    }

    
    public InputStream getReportFileContent() {
        return reportFileContent;
    }

    
    public void setReportFileContent(InputStream reportFileContent) {
        this.reportFileContent = reportFileContent;
    }
}