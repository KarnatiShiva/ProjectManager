package com.fse.pm.service;

import java.util.List;

import com.fse.pm.entities.Project;
import com.fse.pm.mapper.ProjectRequest;
import com.fse.pm.mapper.ProjectResponse;

public interface IProjectService {
	
	public List<ProjectResponse> findAll();
	
	public Project findProject(Integer projectId) ;
	
	public List<ProjectResponse> updateProject(ProjectRequest request) ;
	
	public List<ProjectResponse> createProject(ProjectRequest request) ;

}
