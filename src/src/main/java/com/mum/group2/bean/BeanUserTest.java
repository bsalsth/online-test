package com.mum.group2.bean;

public class BeanUserTest {
	private int userId;
	private String accessKey; //is a sessionKey in Test table
	private int testId;

	public BeanUserTest() {
		super();
	}

	public BeanUserTest(int userID, int testID) {
		super();
		this.userId = userID;
		this.testId = testID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userID) {
		this.userId = userID;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testID) {
		this.testId = testID;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	
}
