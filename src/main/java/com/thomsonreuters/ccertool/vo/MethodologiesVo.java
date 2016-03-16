package com.thomsonreuters.ccertool.vo;

import java.util.Date;

public class MethodologiesVo {

	
	private int methodologyId;
	
	private String methodologyName;
	
	private String methodologyDescription;
	
	private Date methodologyCreated;
	
	private Date methodologyUpdated;
	
	private String methodologySource;

	
	public int getMethodologyId() {
		return methodologyId;
	}

	
	public void setMethodologyId(int methodologyId) {
		this.methodologyId = methodologyId;
	}

	
	public String getMethodologyName() {
		return methodologyName;
	}

	
	public void setMethodologyName(String methodologyName) {
		this.methodologyName = methodologyName;
	}

	
	public String getMethodologyDescription() {
		return methodologyDescription;
	}

	
	public void setMethodologyDescription(String methodologyDescription) {
		this.methodologyDescription = methodologyDescription;
	}

	
	public Date getMethodologyCreated() {
		return methodologyCreated;
	}

	
	public void setMethodologyCreated(Date methodologyCreated) {
		this.methodologyCreated = methodologyCreated;
	}

	
	public Date getMethodologyUpdated() {
		return methodologyUpdated;
	}

	
	public void setMethodologyUpdated(Date methodologyUpdated) {
		this.methodologyUpdated = methodologyUpdated;
	}

	
	public String getMethodologySource() {
		return methodologySource;
	}

	
	public void setMethodologySource(String methodologySource) {
		this.methodologySource = methodologySource;
	}
}