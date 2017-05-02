package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;

public interface UserService {
	public User save(User user);
	public User get(int id);
	public List<User> findAll();
	public User findByUserName(String userName);
	
//	public Test getTestByID(int testID);
}
