package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Answer;
import com.mum.group2.repositories.AnswerRepository;
import com.mum.group2.services.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerRepository answerRepository;

	@Override
	public List<Answer> findAllAnswers() {
		return answerRepository.findAll();
	}

	@Override
	public void deleteAnswer(int answerId) {
		answerRepository.delete(Integer.valueOf(answerId));
	}

	@Override
	public void saveOrUpdateResource(Answer answer) {
		answerRepository.save(answer);
	}

	@Override
	public Answer getAnswerById(int answerId) {
		return answerRepository.findOne(Integer.valueOf(answerId));
	}

}
