package com.fse.pm.dao;

import java.util.List;
import java.util.Optional;

import com.fse.pm.entities.ParentTask;

public interface IParentTaskDao {
	
	public List<ParentTask> findAll();
	
	public Optional<ParentTask> findParent(Integer parentTaskId);
	
	public ParentTask createParent(ParentTask parentTask);

}
