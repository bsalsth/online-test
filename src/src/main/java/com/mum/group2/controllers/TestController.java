package com.mum.group2.controllers;

import java.util.ArrayList;
import java.util.Date;
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
import com.mum.group2.bean.BeanSelectCatSubcat;
import com.mum.group2.bean.BeanTestResult;
import com.mum.group2.bean.BeanTesting;
import com.mum.group2.bean.BeanUserTest;
import com.mum.group2.domain.Question;
import com.mum.group2.domain.Test;
import com.mum.group2.domain.TestQuestion;
import com.mum.group2.domain.User;
import com.mum.group2.services.CategoryService;
import com.mum.group2.services.ConfigurationService;
import com.mum.group2.services.GradeService;
import com.mum.group2.services.QuestionService;
import com.mum.group2.services.SubCategoryService;
import com.mum.group2.services.TestQuestionService;
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
	TestQuestionService tqs;
	
	@Autowired
	QuestionService qs;
	
	@Autowired
	UserService us;
	
	@Autowired
	CategoryService cs;
	
	@Autowired
	SubCategoryService scs;
	
	@Autowired
	ConfigurationService confService;
	
	@Autowired
	GradeService gs;
	
	
	
	//private Vector<SubCategory> vListSubCatToTest = new Vector<>();
	private Hashtable<Integer, List<Question>> listQuestions4Testing = new Hashtable<>();
	
	List<BeanCategory> beanCategoriesModel;
	
	private BeanTesting beanTesting;
	private BeanTestResult beanTestResult;
	
	private Test aTest = new Test();
	
	private int numQuestion = 3;

	
	@RequestMapping(method = RequestMethod.GET)
	public String showStudentLogin(Model model) {
		Utils.serverTime(model);

		model.addAttribute("userTestModel", new BeanUserTest());
		return "testFrontPage";
	}

//	@RequestMapping(value = "/testStatus", method = RequestMethod.POST)
//	public String showStudentStatus(@ModelAttribute("userTestModel") BeanUserTest ut, Model model) {
//		User student = us.get(ut.getUserId());
//		Test t = student.getTestFromTestID(ut.getTestId());
//		
//		model.addAttribute("userModel", student);
//		model.addAttribute("testModel", t);
//		
//		return "testInfo";
//	}

//	//For integration, following Jose approaching
	@RequestMapping(value = "/testStatus", method = RequestMethod.POST)
	public String showStudentStatus(@ModelAttribute("userTestModel") BeanUserTest ut, Model model) {
		String accessKey = ut.getAccessKey();
		
		aTest = ts.findByAccessKey(accessKey);
		
		model.addAttribute("testModel", aTest);
		
		return "testInfo";
	}
	
	@RequestMapping(value = "/selectCatSubcat", method = RequestMethod.GET)
	public String selectCatSubcat(Model model) {
		numQuestion = Integer.parseInt(confService.findConfigurationValue("numberOfQuestions"));
		
		beanCategoriesModel = cs.getAllCategories(numQuestion);
		model.addAttribute("categoriesModel", beanCategoriesModel);
		model.addAttribute("categoriesJSON", JSONArray.fromObject(beanCategoriesModel));
		model.addAttribute("selectCatSubcat", new BeanSelectCatSubcat());
		return "testSelectCatSubcat";
	}
	
	@RequestMapping(value = "/selectCatSubcat", method = RequestMethod.POST)
	public String startATest(@Valid @ModelAttribute("selectCatSubcat") BeanSelectCatSubcat selectCatSubcat, RedirectAttributes redirectAttributes) {

		//@TODO: save information about the test to DB
		
		/*
		 * 1. Get SubCategory list base on student selected in /selectCatSubcat page
		 * 2. Travel from each SubCategory, select random 20 questions to a list
		 * 3. Show the first question to student
		 */
		
		
		//reset the list
		listQuestions4Testing = new Hashtable<>();
		Hashtable<String, Integer> listResultForTest = new Hashtable<>();
		
		beanTesting = new BeanTesting(beanCategoriesModel, listQuestions4Testing);
		BeanUtils.copyProperties(selectCatSubcat, beanTesting);
		
		for (Integer subCatId : selectCatSubcat.getSubCatId()) {
			List<Question> listQues = scs.getFirstNQuestion(subCatId, numQuestion);
			listQuestions4Testing.put(subCatId, listQues);
			listResultForTest.put(beanTesting.findSubcatName(beanTesting.getCatId(), subCatId), 0);
		}
		beanTesting.setCurSubcatPos(beanTesting.getCurSubcatPos());
		beanTesting.setCurQuesPos(beanTesting.getCurQuesPos());
		
		User u = aTest.getUser();
		if (u == null) {
			u = new User("mkt", "", "Minh", "Truong", "email@email.com");
		}
		beanTesting.setStudent(u);
		
		//For test result page
		beanTestResult = new BeanTestResult(gs);
		beanTestResult.setStudentName(u.getFirstName() + " " + u.getLastName());
		beanTestResult.setCatNameOfTest(beanTesting.findCatName(beanTesting.getCatId()));
		beanTestResult.setTotalQuestion(numQuestion);
		beanTestResult.setListResultForTest(listResultForTest);
		
		redirectAttributes.addFlashAttribute("beanTesting", beanTesting);
		return "redirect:/test/start";
	}	
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startTest(@ModelAttribute("beanTesting") BeanTesting beanTestingModel, Model model) {
		if (beanCategoriesModel == null) {
			beanCategoriesModel = cs.getAllCategories(numQuestion);
		}

		model.addAttribute("beanTesting", beanTesting); //keep tracking the testing progress
		return "testStart";
	}
	
	List<TestQuestion> listTestQues4SavingToDB = new ArrayList<>();
	
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String onGoingTest(@ModelAttribute("beanTesting") BeanTesting beanTestingModel, Model model) {
		model.addAttribute("beanTesting", beanTesting); //keep tracking the testing progress
		
		// check to see if the answer is right of wrong
		int ans4Ques = beanTestingModel.getAns4Ques();
		int rightAnsId = beanTesting.getCurQues().getRightAnswerId();
		
		TestQuestion tq = new TestQuestion();
		tq.setAnswer(ans4Ques);
		if (ans4Ques == rightAnsId) {
			tq.setResult(true);
			Integer result = beanTestResult.getListResultForTest().get(beanTesting.getCurSubcatName());
			result += 1;
			beanTestResult.getListResultForTest().put(beanTesting.getCurSubcatName(), result);
		}
		tq.setQuestion(beanTesting.getCurQues());
		listTestQues4SavingToDB.add(tq);
		
		List<Question> listQues = listQuestions4Testing.get(beanTesting.getCurSubcatId());

		int nextQuestion = beanTesting.getCurQuesPos() + 1;
		//if is there anymore question, continue to the next question
		if (nextQuestion < listQues.size()) {
			beanTesting.setCurQuesPos(nextQuestion);
		} else {
			//Save the student's answer to DB if no more question in current subCat
			
			//Have to be called when merging the code
			saveStudentTestQuestion();
			
			
			//Go to the next subCat's question if we still have some more left
			int nextSucatPos = beanTesting.getCurSubcatPos() + 1;
			
			//if this is the latest question of current subCat, 
			if (nextSucatPos < beanTesting.getSubCatId().size()) {
				//should change to next subCat and reset the current question position to 0 
				// if we still have some un-test subCats
				beanTesting.setCurSubcatPos(nextSucatPos);
				beanTesting.setCurQuesPos(0);
			} else {
				//Finished the test, show the result test page.
				model.addAttribute("beanTestResult", beanTestResult);
				return "testResult";
			}
		}
		
		return "testStart";
	}

	private void saveStudentTestQuestion() {
		aTest.setTestDate(new Date());

		for (TestQuestion tq : listTestQues4SavingToDB) {
			//old approaching
//			aTest.getTestQuestionCollection().add(tqs.save(tq));
			
			//Follow Jose approaching
			tq.setTest(aTest);
			tqs.save(tq);
			
			Question q = tq.getQuestion();
			q.setUsed(true);
			qs.saveOrUpdateQuestion(q);
		}
		
		ts.save(aTest);
	}
}
