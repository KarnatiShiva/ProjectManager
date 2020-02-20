package com.fse.pm.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.pm.dao.IParentTaskDao;
import com.fse.pm.entities.ParentTask;
import com.fse.pm.repositories.IParentTaskRepository;

@Repository
public class ParentTaskDaoImpl implements IParentTaskDao{
	
	private IParentTaskRepository parentTaskRepository;

	@Autowired
	public void setParentTaskRepository(IParentTaskRepository parentTaskRepository) {
		this.parentTaskRepository = parentTaskRepository;
	}

	@Override
	public List<ParentTask> findAll() {
		// TODO Auto-generated method stub
		return parentTaskRepository.findAll();
	}

	@Override
	public Optional<ParentTask> findParent(Integer parentTaskId) {
		// TODO Auto-generated method stub
		return parentTaskRepository.findById(parentTaskId);
	}

	@Override
	public ParentTask createParent(ParentTask parentTask) {
		// TODO Auto-generated method stub
		return parentTaskRepository.save(parentTask);
	}

}
