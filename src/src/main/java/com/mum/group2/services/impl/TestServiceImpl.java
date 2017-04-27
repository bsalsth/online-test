package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Test;
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
 }
