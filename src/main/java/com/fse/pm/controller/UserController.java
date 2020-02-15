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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pm.entities.Users;
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
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		return ResponseEntity.ok().body(service.createUser(user));
	}
	
	@RequestMapping(value="/deleteuser/{did}",method={RequestMethod.GET,RequestMethod.DELETE})
	public void deleteUser(@PathVariable(value = "did") int userId) {
		service.deleteUser(userId);
	}
		
	@PostMapping("/updateuser")
	public ResponseEntity<Users> updateUser(@Valid @RequestBody Users user) {	
		return ResponseEntity.ok().body(service.updateUser(user));
	}

}
