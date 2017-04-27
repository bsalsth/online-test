package com.mum.group2.bean;

public class UserTest {
	private int userId;
	private int testId;

	public UserTest() {
		super();
	}

	public UserTest(int userID, int testID) {
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

}
