package com.mum.group2.bean;

import java.util.Hashtable;

import com.mum.group2.services.GradeService;

public class BeanTestResult {
	private String studentName;
	private String catNameOfTest;
	private int totalQuestion;
	
	private Hashtable<String, Integer> listResultForTest = new Hashtable<>();
	private Hashtable<String, String> listGradeForTest;

	private GradeService gs;

	
	public BeanTestResult(GradeService gs) {
		super();
		this.gs = gs;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCatNameOfTest() {
		return catNameOfTest;
	}

	public void setCatNameOfTest(String catNameOfTest) {
		this.catNameOfTest = catNameOfTest;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public Hashtable<String, Integer> getListResultForTest() {
		return listResultForTest;
	}

	public void setListResultForTest(Hashtable<String, Integer> listResultForTest) {
		this.listResultForTest = listResultForTest;
	}

	public void grading() {
		listGradeForTest = new Hashtable<>();
		
		for (String key : listResultForTest.keySet()) {
			int score = listResultForTest.get(key);
			float f = score/(totalQuestion * 1.0f) * 100;
			listGradeForTest.put(key, "Corrected : " + score + "/" + totalQuestion + " (Grade : " + gs.findGrade(f) + ")");
		}
	}

	public Hashtable<String, String> getListGradeForTest() {
		grading();
		return listGradeForTest;
	}
	
	
}
