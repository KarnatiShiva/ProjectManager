package com.fse.pm.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.pm.dao.IProjectDao;
import com.fse.pm.entities.Project;
import com.fse.pm.repositories.IProjectRepository;

@Repository
public class ProjectDaoImpl implements IProjectDao{
	
	private IProjectRepository projectRepository;

	@Autowired
	public void setProjectRepository(IProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public Optional<Project> findProject(Integer projectId) {
		// TODO Auto-generated method stub
		return projectRepository.findById(projectId);
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}
	
	@Override
	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}
}
