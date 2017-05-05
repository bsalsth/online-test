package com.mum.group2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity (name = "question")
public class Question {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="question_id")
	private int questionId;
	
	private String description;

	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="QUESTION_ANSWER",
    		joinColumns=@JoinColumn(name="question_id", referencedColumnName="question_id"),
    		inverseJoinColumns=@JoinColumn(name="answer_id", referencedColumnName="answer_id"))
	private Collection<Answer> answerCollection;	
	
	private boolean isActive;

	private boolean isUsed;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SUB_CAT_ID")
	private SubCategory subcategory;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Answer> answers = new ArrayList<Answer>();
	
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	public SubCategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
