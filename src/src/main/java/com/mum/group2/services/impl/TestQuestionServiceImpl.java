package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.TestQuestion;
import com.mum.group2.repositories.TestQuestionRepository;
import com.mum.group2.services.TestQuestionService;

@Service
public class TestQuestionServiceImpl implements TestQuestionService {

	@Autowired
	TestQuestionRepository testQuestionRepository;

	@Override
	public TestQuestion save(TestQuestion testQuestion) {
		return testQuestionRepository.save(testQuestion);
	}

	@Override
	public TestQuestion get(int id) {
		return testQuestionRepository.findOne(id);
	}

	@Override
	public List<TestQuestion> findAll() {
		return (List<TestQuestion>) testQuestionRepository.findAll();
	}
	
}
