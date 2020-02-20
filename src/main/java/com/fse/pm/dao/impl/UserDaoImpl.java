package com.fse.pm.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.pm.dao.IUserDao;
import com.fse.pm.entities.Users;
import com.fse.pm.repositories.IUserRepository;

@Repository
public class UserDaoImpl implements IUserDao{
	
	private IUserRepository usersRepository;

	@Autowired
	public void setUsersRepository(IUserRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}

	@Override
	public Optional<Users> findUser(int userId) {
		// TODO Auto-generated method stub
		return usersRepository.findById(userId);
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		return usersRepository.save(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(userId);		
	}


}
