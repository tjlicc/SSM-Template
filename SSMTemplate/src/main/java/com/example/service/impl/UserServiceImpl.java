package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.inter.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

	@Override
	public int insert(User muser) {
		
		return userDao.insert(muser);
	}

	@Override
	public int update(User muser) {
		
		return userDao.updateByPrimaryKey(muser);
	}

	@Override
	public int delete(String id) {
	
		return userDao.deleteByPrimaryKey(id);
	}

	@Override
	public User selectByPrimaryKey(String id) {
		
		return userDao.selectByPrimaryKey(id);
	}

}
