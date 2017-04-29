package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Answer;

public interface AnswerService {
	public List<Answer> findAllAnswers();
	
	public void saveOrUpdateResource(Answer answer);
	
	public Answer getAnswerById(int answerId);

	public void deleteAnswer(int answerId) ;
}
