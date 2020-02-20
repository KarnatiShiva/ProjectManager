/**
 * 
 */
package com.fse.pm.mapper;

/**
 * @author n0222071
 *
 */
public class ParentTaskRequestResponse {	
	
	private int parentId;
	private String parentTask;
		
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
}
