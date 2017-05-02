package com.mum.group2.bean;

import java.util.Date;
import java.util.List;

import com.mum.group2.domain.Category;

public class SelectCatSubcat {
	private int testId;
	private int studentId;
	private String sessionkey;
	private Date testDate;
	private int catId;
	private List<Integer> subCatId;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getCatId() {
		return catId;
	}

	public List<Integer> getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(List<Integer> subCatId) {
		this.subCatId = subCatId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

}
