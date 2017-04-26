package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.User;
import com.mum.group2.repositories.UserRepository;
import com.mum.group2.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User member) {		
		return userRepository.save(member);
	}

	@Override
	public User get(int id) {
		return userRepository.findOne(id);
	}

	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}
 }
