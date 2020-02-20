/**
 * 
 */
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Range;

/**
 * @author Shiva Karnati
 *
 */
@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")	
	private int taskId;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="priority")
	@Range(min=0, max=30)
	private int priority;
	
	@Column(name="task_status")
	private boolean taskStatus;		
	
	@Column(name="task_desc")	
	private String taskDesc;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id", referencedColumnName="parent_id")
	private ParentTask parentTask;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id", referencedColumnName="project_id")
	private Project project;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private Users user;
	
	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}	
	
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public ParentTask getParentTask() {
		return parentTask;
	}
	
	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	
	public boolean isTaskStatus() {
		return taskStatus;
	}
	
	public void setTaskStatus(boolean status) {
		this.taskStatus = status;
	}

}
