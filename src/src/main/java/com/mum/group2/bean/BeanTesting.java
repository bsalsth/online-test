package com.mum.group2.bean;

import java.util.Hashtable;
import java.util.List;

import com.mum.group2.domain.Question;
import com.mum.group2.domain.User;

public class BeanTesting extends BeanSelectCatSubcat {
	private int curSubcatPos = 0;
	private int totalSubcat = 0;
	private int curSubcatId = 0;
	private String curSubcatName = "";
	private int totalQuesInCurSubcat = 0;
	private User student;
	
	private long timeLeft = 0l;

	private int ans4Ques = 0;

	//whenever we start, we have to start with the 1st question in the list
	//(not support resume the previous test in this phase
	private int curQuesPos = 0;
	private Question curQues;

	private List<BeanCategory> beanCategoriesModel;
	private Hashtable<Integer, List<Question>> listQuestions4Testing;
	
	private int dangerTime = 0;
	private int warningTime = 0;
	
	public BeanTesting() {
		super();
	}

	public BeanTesting(List<BeanCategory> beanCategoriesModel, Hashtable<Integer, List<Question>> listQuestions4Testing) {
		super();
		this.beanCategoriesModel = beanCategoriesModel;
		this.listQuestions4Testing = listQuestions4Testing;
		
		setCatName(findCatName(getCatId()));
	}

	public int getCurQuesPos() {
		return curQuesPos;
	}

	public void setCurQuesPos(int currentQuestionPos) {
		this.curQuesPos = currentQuestionPos;
		List<Question> listQuesOfCurSubcat = listQuestions4Testing.get(curSubcatId);
		if (listQuesOfCurSubcat.size() != 0) {
			curQues = listQuesOfCurSubcat.get(curQuesPos);
		} else {
			curQues = new Question();
			curQues.setDescription("Contact Administrator for having the questions for this Subcategory...");
		}
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

	public int getCurSubcatPos() {
		return curSubcatPos;
	}

	public void setCurSubcatPos(int curSucatPos) {
		this.curSubcatPos = curSucatPos;
		
		setCurSubcatId(getSubCatId().get(curSubcatPos));
		
		totalQuesInCurSubcat = listQuestions4Testing.get(curSubcatId).size();
		
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

	public int getTotalQuesInCurSubcat() {
		return totalQuesInCurSubcat;
	}

	public int getTotalSubcat() {
		return totalSubcat;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}
	
	public String findCatName(int catId) {
		String ret = "";
		//find out the current Category name
		if (beanCategoriesModel != null) {
			for (BeanCategory beanCat : beanCategoriesModel) {
				if (beanCat.getCatId() == catId) {
					ret = beanCat.getDescription();
				}
			}
		}
		
		return ret;
	}

	public String findSubcatName(int catId, Integer subCatId) {
		String ret = "";
		//find out the current Category name
		if (beanCategoriesModel != null) {
			for (BeanCategory beanCat : beanCategoriesModel) {
				if (beanCat.getCatId() == catId) {
					for (BeanSubcat beanSubcat : beanCat.getListSubcat()) {
						if (beanSubcat.getSubCatId() == subCatId) {
							ret = beanSubcat.getDescription();
						}
					}
						
				}
			}
		}
		
		return ret;
	}

	public long getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(long timeLeft) {
		this.timeLeft = timeLeft;
	}

	public void setTotalSubcat(int totalSubcat) {
		this.totalSubcat = totalSubcat;
	}

	public int getDangerTime() {
		return dangerTime;
	}

	public void setDangerTime(int dangerTime) {
		this.dangerTime = dangerTime;
	}

	public int getWarningTime() {
		return warningTime;
	}

	public void setWarningTime(int warningTime) {
		this.warningTime = warningTime;
	}
}
