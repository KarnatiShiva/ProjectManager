package com.fse.pm.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.pm.dao.IUserDao;
import com.fse.pm.entities.Users;
import com.fse.pm.mapper.UserRequestResponse;
import com.fse.pm.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;	

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public Optional<Users> findUser(int userId) {
		// TODO Auto-generated method stub
		Optional<Users> user = userDao.findUser(userId);		
		if(user.isPresent()) {
			return user;
		}
		return Optional.empty();
	}

	@Override
	public UserRequestResponse createUser(UserRequestResponse request) {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setUserId(request.getUserId());
		users.setEmployeeId(request.getEmployeeId());
		users.setLastName(request.getLastName());
		users.setFirstName(request.getFirstName());
		users.setManager(request.isManager());
		userDao.addUser(users);	
		ModelMapper modelMapper = new ModelMapper();
		UserRequestResponse response = modelMapper.map(users, UserRequestResponse.class);
		return response; 
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);		
	}

	@Override
	public UserRequestResponse updateUser(UserRequestResponse request) {
		// TODO Auto-generated method stub
		
		Optional<Users> userData = userDao.findUser(request.getUserId());
		if (userData.isPresent()) {			
			UserRequestResponse updatedUser = createUser(request);
			return updatedUser;
		}
		return null;
	}

}
