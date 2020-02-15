package com.fse.pm.service;

import java.util.List;

import com.fse.pm.entities.ParentTask;

public interface IParentTaskService {
	
	public List<ParentTask> findAll() ;
	
	public ParentTask findParent(Integer parentTaskId) ;
	
	public ParentTask createParent(ParentTask parentTask) ;

}
