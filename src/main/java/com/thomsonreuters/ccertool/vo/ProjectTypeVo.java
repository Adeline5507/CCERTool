package com.thomsonreuters.ccertool.vo;

public class ProjectTypeVo {

	
	private int projectTypeId;
	
	private int projectParentTypeId;
	
	private String projectTypeName;

	
	public int getProjectTypeId() {
		return projectTypeId;
	}

	
	public void setProjectTypeId(int projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	
	public int getProjectParentTypeId() {
		return projectParentTypeId;
	}

	
	public void setProjectParentTypeId(int projectParentTypeId) {
		this.projectParentTypeId = projectParentTypeId;
	}

	
	public String getProjectTypeName() {
		return projectTypeName;
	}

	
	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}
}