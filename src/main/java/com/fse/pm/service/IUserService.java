package com.fse.pm.service;

import java.util.List;
import java.util.Optional;

import com.fse.pm.entities.Users;
import com.fse.pm.mapper.UserRequestResponse;

public interface IUserService {

	public List<Users> findAll();
	
	public Optional<Users> findUser(int userId) ;
	
	public UserRequestResponse createUser(UserRequestResponse user) ;
	
	public UserRequestResponse updateUser(UserRequestResponse user) ;
	
	public void deleteUser(int userId) ;
}
