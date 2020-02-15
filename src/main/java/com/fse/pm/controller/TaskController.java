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

import com.fse.pm.mapper.TaskRequestResponse;
import com.fse.pm.service.ITaskService;


@RestController
@RequestMapping("/projectmanager")
@CrossOrigin
public class TaskController {
	
	@Autowired
	ITaskService service;
	
	/**
	 * find all parents in DB
	 * @return parentList
	 */
	@GetMapping("/alltask")	
	public List<TaskRequestResponse> getAllTasks() {
		return service.findAll();
	}
	
	/**
	 * @param taskId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/viewtask/{tid}")
	public ResponseEntity getTaskBy(@PathVariable(value = "tid") int taskId) {
		return ResponseEntity.ok().body(service.findTask(taskId));
	}
	
	@PostMapping("/addtask")
	public TaskRequestResponse createTask(@Valid @RequestBody TaskRequestResponse request) {
		return service.createTask(request);
	}
	
	@PostMapping("/updatetask")
	public TaskRequestResponse updateTask(@RequestBody TaskRequestResponse request) {		
		return service.updateTask(request);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/endtask/{tid}")
	public ResponseEntity endTask(@PathVariable(value = "tid") Integer taskId) {	
		return ResponseEntity.ok().body(service.endTask(taskId));
	}

}
