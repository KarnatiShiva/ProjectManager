package com.fse.pm.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.pm.dao.IParentTaskDao;
import com.fse.pm.entities.ParentTask;
import com.fse.pm.mapper.ParentTaskRequestResponse;
import com.fse.pm.service.IParentTaskService;

@Transactional
@Service
public class ParentTaskServiceImpl implements IParentTaskService{
	
	@Autowired
	private IParentTaskDao parentTaskDao;	

	@Override
	public List<ParentTask> findAll() {
		// TODO Auto-generated method stub		 
		return parentTaskDao.findAll();
	}

	@Override
	public ParentTask findParent(Integer parentTaskId) {
		// TODO Auto-generated method stub
		Optional<ParentTask> optional = parentTaskDao.findParent(parentTaskId);		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public ParentTaskRequestResponse createParent(ParentTaskRequestResponse request) {
		// TODO Auto-generated method stub
		ParentTask parentTask = new ParentTask();
		parentTask.setParentTask(request.getParentTask());
		parentTaskDao.createParent(parentTask);		
		ModelMapper modelMapper = new ModelMapper();
		ParentTaskRequestResponse response = modelMapper.map(parentTask, ParentTaskRequestResponse.class);
		return response;		
	}
}
