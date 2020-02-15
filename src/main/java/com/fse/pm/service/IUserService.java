package com.fse.pm.service;

import java.util.List;
import java.util.Optional;

import com.fse.pm.entities.Users;

public interface IUserService {

	public List<Users> findAll();
	
	public Optional<Users> findUser(int userId) ;
	
	public Users createUser(Users user) ;
	
	public Users updateUser(Users user) ;
	
	public void deleteUser(int userId) ;
}
