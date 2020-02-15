package com.fse.pm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parent_task")
public class ParentTask {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parent_id")
	private int parentId;
	
	@Column(name="parent_task")
	private String parentTask;
	
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getParentTask() {
		return this.parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
}
