package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Question;
import com.mum.group2.repositories.QuestionRepository;
import com.mum.group2.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public List<Question> findAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question saveOrUpdateQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question getQuestionById(int questionId) {
		return questionRepository.findOne(Integer.valueOf(questionId));
	}

	@Override
	public void deleteQuestion(int questionId) {
		questionRepository.delete(Integer.valueOf(questionId));
	}

	
	@Override
	public Question findByDescription(String description) {
		return questionRepository.findByDescription(description);
	}
	
}
