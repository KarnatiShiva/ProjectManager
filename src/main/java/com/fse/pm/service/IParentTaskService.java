package com.fse.pm.service;

import java.util.List;

import com.fse.pm.entities.ParentTask;
import com.fse.pm.mapper.ParentTaskRequestResponse;

public interface IParentTaskService {
	
	public List<ParentTask> findAll() ;
	
	public ParentTask findParent(Integer parentTaskId) ;
	
	public ParentTaskRequestResponse createParent(ParentTaskRequestResponse parentTask) ;

}
