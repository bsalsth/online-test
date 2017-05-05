package com.mum.group2.controllers;

import java.util.Hashtable;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.group2.Utils;
import com.mum.group2.bean.BeanCategory;
import com.mum.group2.bean.BeanTesting;
import com.mum.group2.bean.SelectCatSubcat;
import com.mum.group2.bean.UserTest;
import com.mum.group2.domain.Question;
import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;
import com.mum.group2.services.CategoryService;
import com.mum.group2.services.SubCategoryService;
import com.mum.group2.services.TestService;
import com.mum.group2.services.UserService;

import net.sf.json.JSONArray;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/test")

public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService ts;
	
	@Autowired
	UserService us;
	
	@Autowired
	CategoryService cs;
	
	@Autowired
	SubCategoryService scs;
	
	//private Vector<SubCategory> vListSubCatToTest = new Vector<>();
	private Hashtable<Integer, List<Question>> listQuestions4Testing = new Hashtable<>();
	
	List<BeanCategory> beanCategoriesModel;
	BeanTesting beanTesting;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showStudentLogin(Model model) {
		Utils.serverTime(model);
		
		model.addAttribute("userTestModel", new UserTest());
		return "testFrontPage";
	}

	@RequestMapping(value = "/testStatus", method = RequestMethod.POST)
	public String showStudentStatus(@ModelAttribute("userTestModel") UserTest ut, Model model) {
		User student = us.get(ut.getUserId());
		Test t = student.getTestFromTestID(ut.getTestId());
		
		model.addAttribute("userModel", student);
		model.addAttribute("testModel", t);
		
		return "testInfo";
	}
	
	@RequestMapping(value = "/selectCatSubcat", method = RequestMethod.GET)
	public String selectCatSubcat(Model model) {
		beanCategoriesModel = cs.getAllCategories();
		model.addAttribute("categoriesModel", beanCategoriesModel);
		model.addAttribute("categoriesJSON", JSONArray.fromObject(beanCategoriesModel));
		model.addAttribute("selectCatSubcat", new SelectCatSubcat());
		return "testSelectCatSubcat";
	}
	
	@RequestMapping(value = "/selectCatSubcat", method = RequestMethod.POST)
	public String startATest(@Valid @ModelAttribute("selectCatSubcat") SelectCatSubcat selectCatSubcat, RedirectAttributes redirectAttributes) {

		//@TODO: save information about the test to DB
		
		/*
		 * 1. Get SubCategory list base on student selected in /selectCatSubcat page
		 * 2. Travel from each SubCategory, select random 20 questions to a list
		 * 3. Show the first question to student
		 */
		
		//TODO: get number of question/subCat from configuration
		int numQuestion = 3;
		
		for (Integer subCatId : selectCatSubcat.getSubCatId()) {
			List<Question> listQues = scs.getFirstNQuestion(subCatId, numQuestion);
			listQuestions4Testing.put(subCatId, listQues);
		}
		
		beanTesting = new BeanTesting(beanCategoriesModel, listQuestions4Testing);
		BeanUtils.copyProperties(selectCatSubcat, beanTesting);
		beanTesting.setCurSubcatPos(beanTesting.getCurSucatPos());
		beanTesting.setCurQuesPos(beanTesting.getCurQuesPos());
		
		redirectAttributes.addFlashAttribute("beanTesting", beanTesting);
		return "redirect:/test/start";
	}	
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startTest(@ModelAttribute("beanTesting") BeanTesting beanTestingModel, Model model) {
		if (beanCategoriesModel == null) {
			beanCategoriesModel = cs.getAllCategories();
		}

		model.addAttribute("beanTesting", beanTesting); //keep tracking the testing progress
		return "testStart";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String onGoingTest(@ModelAttribute("beanTesting") BeanTesting beanTestingModel, Model model) {
		
		//TODO: check to see if the answer is right of wrong
		int ans4Ques = beanTestingModel.getAns4Ques();
		//continue to compare with result and put to some where :)
		
		
		/*
		 * 1. Save the student's answer to DB if no more question in current subCat
		 * otherwise, continue to the next question
		 */
		List<Question> listQues = listQuestions4Testing.get(beanTesting.getCurSubcatId());

		int nextQuestion = beanTesting.getCurQuesPos() + 1;
		if (nextQuestion < listQues.size()) {
			beanTesting.setCurQuesPos(nextQuestion);
		} else {
			//this is the latest question of current subCat, 
			int curSucatPos = beanTesting.getCurSucatPos();
			
			int nextSucatPos = curSucatPos + 1;
			if (nextSucatPos < beanTesting.getSubCatId().size()) {
				//should change to next subCat and reset the current question position to 0 
				// if we still have some un-test subCats
				beanTesting.setCurSubcatPos(nextSucatPos);
				beanTesting.setCurQuesPos(0);
			}
		}
		
		model.addAttribute("beanTesting", beanTesting); //keep tracking the testing progress
		return "testStart";
	}
}
