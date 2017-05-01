package com.mum.group2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name = "Test_Question")
public class TestQuestion {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="test_question_id")
	private int testQuestionId;
	
	private int answer;

	private boolean result;
	
	@OneToOne
	@JoinColumn(name="question_id")
	private Question question;

	public TestQuestion(int testQuestionId, int answer, Question question) {
		super();
		this.testQuestionId = testQuestionId;
		this.answer = answer;
		this.question = question;
	}

	public TestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTestQuestionId() {
		return testQuestionId;
	}

	public void setTestQuestionId(int testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	
}
