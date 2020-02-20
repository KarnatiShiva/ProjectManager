package com.fse.pm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.pm.dao.IProjectDao;
import com.fse.pm.entities.Project;
import com.fse.pm.mapper.ProjectRequest;
import com.fse.pm.mapper.ProjectResponse;
import com.fse.pm.repositories.IUserRepository;
import com.fse.pm.service.IProjectService;

@Transactional
@Service
public class ProjectServiceImpl implements IProjectService{
	
	@Autowired
	private IProjectDao projectDao;	
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public List<ProjectResponse> findAll() {
		// TODO Auto-generated method stub
		List<Project> projects = projectDao.findAll();
		List<ProjectResponse> projectResps = new ArrayList<>();
		for (Project project : projects) {
			ProjectResponse projectResp = projectResponseMapper(project);
			projectResps.add(projectResp);
		}
		return projectResps;		
	}

	@Override
	public Project findProject(Integer projectId) {
		// TODO Auto-generated method stub
		Optional<Project> optional = projectDao.findProject(projectId);		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<ProjectResponse> updateProject(ProjectRequest request) {
		// TODO Auto-generated method stub
		Project projectReq = new Project();
		Optional<Project> optional = projectDao.findProject(request.getProjectId());
		if(optional.isPresent()) {
			projectReq = optional.get();			
		}
		projectReq.setProjectDesc(request.getProjectDesc());
		projectReq.setStartDate(request.getProjectStartDate());
		projectReq.setEndDate(request.getProjectEndDate());
		projectReq.setPriority(request.getProjectPriority());
		projectReq.setProjectStatus(request.isProjectStatus());
		projectReq.setUser(userRepository.getOne(request.getUserId()));		
		projectDao.addProject(projectReq);
		List<ProjectResponse> projectResps = findAll();
		return projectResps;
	}

	@Override
	public List<ProjectResponse> createProject(ProjectRequest request) {
		// TODO Auto-generated method stub
		Project projectReq = new Project();

		projectReq.setProjectDesc(request.getProjectDesc());
		projectReq.setStartDate(request.getProjectStartDate());
		projectReq.setEndDate(request.getProjectEndDate());
		projectReq.setPriority(request.getProjectPriority());
		projectReq.setUser(userRepository.getOne(request.getUserId()));
	
		projectDao.addProject(projectReq);

		List<ProjectResponse> projectResps = findAll();

		return projectResps;

	}
	
	private ProjectResponse projectResponseMapper(Project project) {
		
		ProjectResponse resp = new ProjectResponse();
		
		resp.setProjectId(project.getProjectId());
		resp.setProjectDesc(project.getProjectDesc());
		resp.setProjectStartDate(project.getStartDate());
		resp.setProjectEndDate(project.getEndDate());
		resp.setProjectPriority(project.getPriority());
		resp.setUserId(project.getUser().getUserId());
		resp.setFirstName(project.getUser().getFirstName());
		resp.setLastName(project.getUser().getLastName());
		resp.setEmployeeId(project.getUser().getEmployeeId());
		resp.setNumberOfTasks(project.getTaskCount());
		resp.setCompletedTasks(project.getCompletedTaskCount());		
		resp.setProjectStatus(project.isProjectStatus());
		return resp;
	}

}
