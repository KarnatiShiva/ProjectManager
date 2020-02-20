package com.fse.pm.dao;

import java.util.List;
import java.util.Optional;

import com.fse.pm.entities.Project;

public interface IProjectDao {

	public List<Project> findAll();
	public Optional<Project> findProject(Integer projectId);
	public Project addProject(Project project);
	public Project updateProject(Project project);
}
