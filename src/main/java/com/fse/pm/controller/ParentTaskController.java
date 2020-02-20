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

import com.fse.pm.entities.ParentTask;
import com.fse.pm.mapper.ParentTaskRequestResponse;
import com.fse.pm.service.IParentTaskService;

@RestController
@RequestMapping("/projectmanager")
@CrossOrigin
public class ParentTaskController {
	
	@Autowired
	IParentTaskService service;
	
	/**
	 * find all parents in DB
	 * @return parentList
	 */
	@GetMapping("/allparenttask")	
	public List<ParentTask> getAllParents() {
		return service.findAll();
	}
	
	/**
	 * @param parentTaskId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/viewparenttask/{ptid}")
	public ResponseEntity getParentBy(@PathVariable(value = "ptid") int parentTaskId) {
		return ResponseEntity.ok().body(service.findParent(parentTaskId));
	}
	
	@PostMapping("/addparenttask")
	public ResponseEntity<ParentTaskRequestResponse> createParent(@Valid @RequestBody ParentTaskRequestResponse parentTask) {
		return ResponseEntity.ok().body(service.createParent(parentTask));
	}

}
