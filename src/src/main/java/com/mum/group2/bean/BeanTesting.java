package com.mum.group2.bean;

import java.util.Hashtable;
import java.util.List;

import com.mum.group2.domain.Question;

public class BeanTesting extends SelectCatSubcat {
	private int curSucatPos = 0;
	private int curSubcatId = 0;
	private String curSubcatName = "";

	private int ans4Ques = 0;

	//whenever we start, we have to start with the 1st question in the list
	//(not support resume the previous test in this phase
	private int curQuesPos = 0;
	private Question curQues;

	private List<BeanCategory> beanCategoriesModel;
	private Hashtable<Integer, List<Question>> listQuestions4Testing;
	
	public BeanTesting() {
		super();
	}

	public BeanTesting(List<BeanCategory> beanCategoriesModel, Hashtable<Integer, List<Question>> listQuestions4Testing) {
		super();
		this.beanCategoriesModel = beanCategoriesModel;
		this.listQuestions4Testing = listQuestions4Testing;
	}

	public int getCurQuesPos() {
		return curQuesPos;
	}

	public void setCurQuesPos(int currentQuestionPos) {
		this.curQuesPos = currentQuestionPos;
		curQues = listQuestions4Testing.get(getCurSubcatId()).get(curQuesPos);
	}

	public int getCurSubcatId() {
		return curSubcatId;
	}

	public void setCurSubcatId(int currentSubcatId) {
		this.curSubcatId = currentSubcatId;
	}

	public String getCurSubcatName() {
		return curSubcatName;
	}

	public void setCurSubcatName(String curSubcatName) {
		this.curSubcatName = curSubcatName;
	}

	public int getCurSucatPos() {
		return curSucatPos;
	}

	public void setCurSubcatPos(int curSucatPos) {
		this.curSucatPos = curSucatPos;
		
		setCurSubcatId(getSubCatId().get(getCurSucatPos()));
		
		if (beanCategoriesModel == null) {
			return;
		}
		for (BeanCategory beanCat : beanCategoriesModel) {
			if (beanCat.getCatId() == getCatId()) {
				for (BeanSubcat beanSubcat : beanCat.getListSubcat())
					if (beanSubcat.getSubCatId() == curSubcatId) {
						setCurSubcatName(beanSubcat.getDescription());
					}
			}
		}
	}

	public Question getCurQues() {
		return curQues;
	}

	public int getAns4Ques() {
		return ans4Ques;
	}

	public void setAns4Ques(int ans4Ques) {
		this.ans4Ques = ans4Ques;
	}
	
	
}
