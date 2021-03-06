package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;
import com.mum.group2.repositories.UserRepository;
import com.mum.group2.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {		
		return userRepository.save(user);
	}

	@Override
	public User get(int id) {
		return userRepository.findOne(id);
	}

	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	
	

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);;
		
	}

//	@Override
//	public Test getTestByID(int testID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
 }
