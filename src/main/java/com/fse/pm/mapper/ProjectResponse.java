package com.fse.pm.mapper;

import java.util.Date;

/**
 * @author Shiva Karnati
 *
 */

public class ProjectResponse {
	
	private int projectId;
	private String projectDesc;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private int numberOfTasks;
	private int completedTasks;
	private int userId;
	private String firstName;
	private String lastName;
	private int employeeId;
	private boolean projectStatus;
	
	public int getCompletedTasks() {
		return completedTasks;
	} 
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getNumberOfTasks() {
		return numberOfTasks;
	}
	
	public Date getProjectEndDate() {
		return projectEndDate;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public String getProjectDesc() {
		return projectDesc;
	}
	
	public int getProjectPriority() {
		return projectPriority;
	}
	
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	
	public int getUserId() {
		return userId;
	}

	public boolean isProjectStatus() {
		return projectStatus;
	}
	
	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	} 
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setNumberOfTasks(int numberOfTasks) {
		this.numberOfTasks = numberOfTasks;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
	
	public void setProjectStatus(boolean projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}	

}
