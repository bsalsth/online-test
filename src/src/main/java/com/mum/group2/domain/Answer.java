package com.mum.group2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name = "answer")
public class Answer {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="answer_id")
	private int answerId;
	
	private String description;
	
	@Column(name="right_answer")
	private Boolean isRightAnswer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="QUESTION_ID")
	private Question question;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(String description, boolean isRightAnswer) {
		super();
		this.description = description;
		this.isRightAnswer = isRightAnswer;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isRightAnswer() {
		return isRightAnswer;
	}

	public void setRightAnswer(Boolean isRightAnswer) {
		if (isRightAnswer == null) {
			isRightAnswer = new Boolean(false);
		} else {
			this.isRightAnswer = isRightAnswer;
		}
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}

