package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.User;

public interface UserService {
	public User save(User member);
	public User get(int id);
	public List<User> findAll();
}
