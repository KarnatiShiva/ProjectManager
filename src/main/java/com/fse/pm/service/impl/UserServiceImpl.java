package com.fse.pm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.pm.dao.IUserDao;
import com.fse.pm.entities.Users;
import com.fse.pm.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;	

	/*@Autowired
	public void setParentTaskDao(IParentTaskDao parentTaskDao) {
		this.parentTaskDao = parentTaskDao;
	}*/

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
		return null;
	}

	@Override
	public Users createUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);		
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		
		Optional<Users> userData = userDao.findUser(new Integer(user.getUserId()));
		if (userData.isPresent()) {
			Users userInfo = userData.get();
			userInfo.setFirstName(user.getFirstName());
			userInfo.setLastName(user.getLastName());
			Users updatedUser = createUser(user);
			return updatedUser;
		}
		return null;
	}

}
