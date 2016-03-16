package com.thomsonreuters.ccertool.vo;

public class ProjectCategoriesVo {
	private int projectCategoryId;
	private String name;
	private String description;
	public int getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setProjectCategoryId(int projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
