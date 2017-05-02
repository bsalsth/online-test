package com.mum.group2.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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

@Entity (name = "test")
public class Test {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="test_id")
	private int testId;

	@Column(name="session_key")
	private String sessionKey;
	
	@Column(name="test_date")
	private Date testDate;

	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="TEST_TESTQUESTION",
    		joinColumns=@JoinColumn(name="test_id", referencedColumnName="test_id"),
    		inverseJoinColumns=@JoinColumn(name="test_question_id", referencedColumnName="test_question_id"))
	private Collection<TestQuestion> testQuestionCollection;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "test", cascade = CascadeType.ALL)
	private List<TestQuestion> testQuestions = new ArrayList<TestQuestion>();
	
	public Test() {
		super();
	}

	public Test(String sessionKey, Date testDate) {
		super();
		this.sessionKey = sessionKey;
		this.testDate = testDate;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TestQuestion> getTestQuestions() {
		Collections.sort(testQuestions);
		return testQuestions;
	}

	public void setTestQuestions(List<TestQuestion> testQuestions) {
		this.testQuestions = testQuestions;
	}
	
}
