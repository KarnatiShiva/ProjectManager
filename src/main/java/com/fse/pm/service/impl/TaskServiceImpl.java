package com.fse.pm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.pm.dao.ITaskDao;
import com.fse.pm.dao.IUserDao;
import com.fse.pm.entities.Task;
import com.fse.pm.entities.Users;
import com.fse.pm.mapper.TaskRequestResponse;
import com.fse.pm.repositories.IParentTaskRepository;
import com.fse.pm.repositories.IProjectRepository;
import com.fse.pm.service.ITaskService;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService{
	
	@Autowired
	private ITaskDao taskDao;
	
	@Autowired
	private IUserDao userDao;	
			
	@Autowired
	private IProjectRepository projectRepository;
	
	@Autowired
	private IParentTaskRepository parentTaskRepository;
	
	@Override
	public List<TaskRequestResponse> findAll() {
		// TODO Auto-generated method stub
		List<Task> tasks = taskDao.findAll();		
		List<TaskRequestResponse> taskResps = new ArrayList<>();
		for (Task task : tasks) {
			TaskRequestResponse taskResp = taskResponseMapper(task);
			taskResps.add(taskResp);
		}
		return taskResps;		
	}

	@Override
	public Task findTask(Integer taskId) {
		// TODO Auto-generated method stub
		Optional<Task> optional = taskDao.findTask(taskId);		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public TaskRequestResponse createTask(TaskRequestResponse request) {
		// TODO Auto-generated method stub
		Task task = new Task();		
		task.setStartDate(request.getStartDate());
		task.setEndDate(request.getEndDate());
		task.setTaskDesc(request.getTaskDesc());
		task.setPriority(request.getPriority());
		task.setTaskStatus(request.isTaskStatus());
		if (request.getParentId() != 0) {
			task.setParentTask(parentTaskRepository.getOne(request.getParentId()));
		}
		task.setProject(projectRepository.getOne(request.getProjectId()));			
		Optional<Users> user = userDao.findUser(request.getUserId());
		if(user.isPresent()) {
			task.setUser(user.get());
		}		
		return taskResponseMapper(taskDao.addTask(task));	
	}

	@Override
	public TaskRequestResponse updateTask(TaskRequestResponse request) {
		// TODO Auto-generated method stub
		Task task = new Task();
		Optional<Task> optional = taskDao.findTask(request.getTaskId());
		if (optional.isPresent()) {
			task = optional.get();
		}
			task.setTaskDesc(request.getTaskDesc());
			task.setEndDate(request.getEndDate());
			task.setStartDate(request.getStartDate());
			task.setTaskStatus(request.isTaskStatus());
			task.setPriority(request.getPriority());
			if (request.getParentId() != 0) {
				task.setParentTask(parentTaskRepository.getOne(request.getParentId()));
			}
			task.setProject(projectRepository.getOne(request.getProjectId()));			
			Optional<Users> user = userDao.findUser(request.getUserId());
			if(user.isPresent()) {
				task.setUser(user.get());
			}					
			return taskResponseMapper(taskDao.addTask(task));		
	}
	
	private TaskRequestResponse taskResponseMapper(Task task) {
		TaskRequestResponse taskReqResp = new TaskRequestResponse();

		taskReqResp.setTaskId(task.getTaskId());
		taskReqResp.setTaskDesc(task.getTaskDesc());
		taskReqResp.setStartDate(task.getStartDate());
		taskReqResp.setEndDate(task.getEndDate());
		taskReqResp.setPriority(task.getPriority());
		taskReqResp.setTaskStatus(task.isTaskStatus());
		taskReqResp.setParentId(task.getParentTask().getParentId());
		taskReqResp.setParentTask(task.getParentTask().getParentTask());
		taskReqResp.setProjectId(task.getProject().getProjectId());
		taskReqResp.setProjectName(task.getProject().getProjectDesc());
		taskReqResp.setProjectStartDate(task.getProject().getStartDate());
		taskReqResp.setProjectEndDate(task.getProject().getEndDate());
		taskReqResp.setProjectPriority(task.getProject().getPriority());
		taskReqResp.setProjectStatus(task.getProject().isProjectStatus());
		taskReqResp.setUserId(task.getUser().getUserId());
		taskReqResp.setFirstName(task.getUser().getFirstName());
		taskReqResp.setLastName(task.getUser().getLastName());
		taskReqResp.setEmployeeId(task.getUser().getEmployeeId());
		return taskReqResp;
	}
	
	@Override
	public Task endTask(Integer taskId) {
		// TODO Auto-generated method stub
		return null;
	}

}
