package com.mum.group2.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Question {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="question_id")
	private int questionId;
	
	private String description;

	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="question_answer",
    		joinColumns=@JoinColumn(name="question_id", referencedColumnName="question_id"),
    		inverseJoinColumns=@JoinColumn(name="answer_id", referencedColumnName="answer_id"))
	private Collection<Answer> answerCollection;	
	
	
	public Question() {
		super();
	}

	public Question(String description) {
		super();
		this.description = description;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Answer> getAnswerCollection() {
		return answerCollection;
	}

	public void setAnswerCollection(Collection<Answer> answerCollection) {
		this.answerCollection = answerCollection;
	}
	
	
}
