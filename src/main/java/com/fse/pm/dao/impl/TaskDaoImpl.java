package com.fse.pm.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.pm.dao.ITaskDao;
import com.fse.pm.entities.Task;
import com.fse.pm.repositories.ITaskRepository;

@Repository
public class TaskDaoImpl implements ITaskDao{
	
	private ITaskRepository taskRepository;

	@Autowired
	public void setTaskRepository(ITaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> findTask(Integer taskId) {
		// TODO Auto-generated method stub
		return taskRepository.findById(taskId);
	}

	@Override
	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

}
