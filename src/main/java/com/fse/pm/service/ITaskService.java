package com.fse.pm.service;

import java.util.List;

import com.fse.pm.entities.Task;
import com.fse.pm.mapper.TaskRequestResponse;

public interface ITaskService {
	
	public List<TaskRequestResponse> findAll();
	public Task findTask(Integer taskId) ;
	public TaskRequestResponse createTask(TaskRequestResponse request) ;
	public Task endTask(Integer taskId) ;
	public TaskRequestResponse updateTask(TaskRequestResponse request);

}
