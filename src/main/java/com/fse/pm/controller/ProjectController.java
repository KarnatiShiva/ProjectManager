package com.fse.pm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pm.mapper.ProjectRequest;
import com.fse.pm.mapper.ProjectResponse;
import com.fse.pm.service.IProjectService;

@RestController
@RequestMapping("/projectmanager")
@CrossOrigin
public class ProjectController {

	@Autowired
	IProjectService service;
	
	/**
	 * find all parents in DB
	 * @return parentList
	 */
	@GetMapping("/allproject")	
	public List<ProjectResponse> getAllProjects() {
		return service.findAll();
	}
	
	/**
	 * @param projectId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/viewproject/{pid}")
	public ResponseEntity getProjectBy(@PathVariable(value = "pid") int projectId) {
		return ResponseEntity.ok().body(service.findProject(projectId));
	}
	
	@PostMapping("/updateproject")
	public List<ProjectResponse> updateProject(@Valid @RequestBody ProjectRequest request) {
		return service.updateProject(request);
	}
		
	@PostMapping("/addproject")
	public List<ProjectResponse> createProject(@Valid @RequestBody ProjectRequest request) {
		//return ResponseEntity.ok().body(service.createProject(request));
		return service.createProject(request);
	}
}
