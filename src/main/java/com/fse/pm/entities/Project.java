package com.fse.pm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")	
	private int projectId;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="priority")
	@Range(min=0, max=30)
	private int priority;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="project_desc")
	private String projectDesc;
	
	@Column(name="project_status")
	private boolean projectStatus;	
	
	@Formula("(SELECT COUNT(*) FROM TASK WHERE TASK.PROJECT_ID = PROJECT_ID) ")
	private int numberOfTasks;
	
	@Formula("(SELECT COUNT(*) FROM TASK WHERE TASK.PROJECT_ID = PROJECT_ID AND TASK.TASK_STATUS = 0) ")
	private int completedTasks;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private Users user;
	
	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}	

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public int getTaskCount() {
		return numberOfTasks;
	}

	public void setTaskCount(int taskCount) {
		this.numberOfTasks = taskCount;
	}
	
	public int getCompletedTaskCount() {
		return completedTasks;
	}

	public void setCompletedTaskCount(int taskCount) {
		this.completedTasks = taskCount;
	}
	
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	
	public boolean isProjectStatus() {
		return projectStatus;
	}
	
	public void setProjectStatus(boolean projectStatus) {
		this.projectStatus = projectStatus;
	}


}
