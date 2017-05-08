package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.TestQuestion;

public interface TestQuestionService {
	public TestQuestion save(TestQuestion test);
	public TestQuestion get(int id);
	public List<TestQuestion> findAll();
}
