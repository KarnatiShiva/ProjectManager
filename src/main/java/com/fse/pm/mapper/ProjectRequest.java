package com.fse.pm.mapper;

import java.util.Date;

/**
 * @author Shiva Karnati
 *
 */

public class ProjectRequest {
	
	private int userId;
	private String firstName;
	private String lastName;
	private int employeeId;
	private int projectId;
	private String projectDesc;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private boolean projectStatus;	
		
	public boolean isProjectStatus() {
		return projectStatus;
	}
	
	public void setProjectStatus(boolean status) {
		this.projectStatus = status;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public int getProjectId() {
		return projectId;
	}	
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectDesc() {
		return projectDesc;
	}
	
	public void setProjectDesc(String project) {
		this.projectDesc = project;
	}
	
	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
	public int getProjectPriority() {
		return projectPriority;
	}
	
	public Date getProjectStartDate() {
		return projectStartDate;
	}

}
