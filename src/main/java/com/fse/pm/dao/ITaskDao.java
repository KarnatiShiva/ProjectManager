package com.fse.pm.dao;

import java.util.List;
import java.util.Optional;

import com.fse.pm.entities.Task;

public interface ITaskDao {
	
	public List<Task> findAll();
	
	public Optional<Task> findTask(Integer taskId);
	
	public Task addTask(Task task);

}
