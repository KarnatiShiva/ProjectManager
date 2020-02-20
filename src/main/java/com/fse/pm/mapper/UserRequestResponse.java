/**
 * 
 */
package com.fse.pm.mapper;

/**
 * @author Shiva Karnati
 *
 */
public class UserRequestResponse {
	
	private int userId;
	private String firstName;
	private String lastName;
	private int employeeId;	
	private boolean manager;	
		
	public boolean isManager() {
		return manager;
	}
	
	public void setManager(boolean status) {
		this.manager = status;
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

}
