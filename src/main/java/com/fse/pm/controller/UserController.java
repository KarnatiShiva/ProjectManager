package com.fse.pm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pm.entities.Users;
import com.fse.pm.mapper.UserRequestResponse;
import com.fse.pm.service.IUserService;

@RestController
@RequestMapping("/projectmanager")
@CrossOrigin
public class UserController {
	
	@Autowired
	IUserService service;
	
	/**
	 * find all parents in DB
	 * @return parentList
	 */
	@GetMapping("/allusers")	
	public List<Users> getAllUsers() {
		return service.findAll();
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/viewuser/{uid}")
	public ResponseEntity getUserBy(@PathVariable(value = "uid") int userId) {
		return ResponseEntity.ok().body(service.findUser(userId));
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<UserRequestResponse> createUser(@Valid @RequestBody UserRequestResponse user) {
		return ResponseEntity.ok().body(service.createUser(user));
	}
	
	@DeleteMapping("/deleteuser/{did}")
	public void deleteUser(@PathVariable(value = "did") int userId) {
		service.deleteUser(userId);
	}
		
	@PostMapping("/updateuser")
	public ResponseEntity<UserRequestResponse> updateUser(@Valid @RequestBody UserRequestResponse user) {	
		return ResponseEntity.ok().body(service.updateUser(user));
	}

}
