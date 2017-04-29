package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Question;

public interface QuestionService {
	public List<Question> findAllQuestions();
	
	public void saveOrUpdateQuestion(Question question);
	
	public Question getQuestionById(int questionId);

	public void deleteQuestion(int questionId) ;
}
