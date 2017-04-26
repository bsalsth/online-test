package com.mum.group2.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Test {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="test_id")
	private int testId;

	@Column(name="session_key")
	private String sessionKey;
	
	@Column(name="test_date")
	private Date testDate;

	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="test_testquestion",
    		joinColumns=@JoinColumn(name="test_id", referencedColumnName="test_id"),
    		inverseJoinColumns=@JoinColumn(name="test_question_id", referencedColumnName="test_question_id"))
	private Collection<Test_Question> testQuestionCollection;
	
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
	
	
}
