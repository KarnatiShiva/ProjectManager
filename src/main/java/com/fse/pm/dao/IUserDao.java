package com.fse.pm.dao;

import java.util.List;
import java.util.Optional;

import com.fse.pm.entities.Users;

public interface IUserDao {
	
	public List<Users> findAll();
	
	public Optional<Users> findUser(int userId);
	
	public Users addUser(Users user);	
	
	public void deleteUser(int userId);

}
