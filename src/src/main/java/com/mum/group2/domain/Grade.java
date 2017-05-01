package com.mum.group2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "grade")
public class Grade {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="grade_id")
	private int gradeId;
	
	private float min;
	
	private float max;
	
	private String grade;

	public Grade() {
		super();
	}

	public Grade(float min, float max, String grade) {
		super();
		this.min = min;
		this.max = max;
		this.grade = grade;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
