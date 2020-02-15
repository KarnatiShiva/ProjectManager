/**
 * 
 */
/**
 * @author n0222071
 *
 */
package com.fse.pm.mapper;

import java.util.Date;

public class TaskRequestResponse {

	private int taskId;
	private String taskDesc;
	private Date startDate;
	private Date endDate;
	private int priority;
	private boolean taskStatus;
	private int parentId;
	private String parentTask;
	private int projectId;
	private String projectName;
	private Date projectStartDate;
	private Date projectEndDate;
	private int projectPriority;
	private boolean projectStatus;
	private int userId;
	private String firstName;
	private String lastName;
	private int employeeId;
		
	public String getTaskDesc() {
		return taskDesc;
	}	
	
	public boolean isProjectStatus() {
		return projectStatus;
	}
	
	public boolean isTaskStatus() {
		return taskStatus;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public Date getEndDate() {
		return endDate;
	}	
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int i) {
		this.taskId = i;
	}

	public String getLastName() {
		return lastName;
	}
		
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getParentTask() {
		return parentTask;
	}
	
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	public int getProjectId() {
		return projectId;
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String project) {
		this.projectName = project;
	}
	
	public int getProjectPriority() {
		return projectPriority;
	}
	
	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
	}
	
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setProjectStatus(boolean projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public void setTaskDesc(String task) {
		this.taskDesc = task;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
