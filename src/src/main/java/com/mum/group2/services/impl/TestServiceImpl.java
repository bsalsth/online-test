package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;
import com.mum.group2.repositories.TestRepository;
import com.mum.group2.services.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestRepository testRepository;
	
	@Override
	public Test save(Test test) {		
		return testRepository.save(test);
	}

	@Override
	public Test get(int id) {
		return testRepository.findOne(id);
	}

	public List<Test> findAll() {
		return (List<Test>)testRepository.findAll();
	}
	
	@Override
	public Test findByUserAndSessionKey(User user, String sessionKey) {
		return testRepository.findByUserAndSessionKey(user, sessionKey);
	}
	
	@Override
	public List<Test> getAllOrderByTestDate() {
		return testRepository.getAllOrderByTestDate();
	}

	@Override
	public Test findByAccessKey(String sessionKey) {
		return testRepository.findByAccessKey(sessionKey);
	}
	
 }
