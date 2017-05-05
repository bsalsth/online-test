package com.mum.group2.controllers;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.group2.Utils;
import com.mum.group2.bean.BeanCategory;
import com.mum.group2.bean.SelectCatSubcat;
import com.mum.group2.bean.UserTest;
import com.mum.group2.domain.Question;
import com.mum.group2.domain.SubCategory;
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
	
	private Vector<SubCategory> vListSubCatToTest = new Vector<>();
	//private Hashtable<Integer, List<Question>> listQuestions = new Hashtable<>();
	
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

//		List<Category> listCat = cs.findAllCategories();
//		JSONArray jsonObject = JSONArray.fromObject( listCat );
//		model.addAttribute("categories", listCat);
//		model.addAttribute("categoriesJSON", jsonObject);
		
		List<BeanCategory> categoriesModel = cs.getAllCategories();
		model.addAttribute("categoriesModel", categoriesModel);
		model.addAttribute("categoriesJSON", JSONArray.fromObject(categoriesModel));
		model.addAttribute("selectCatSubcat", new SelectCatSubcat());
		return "testSelectCatSubcat";
	}
	
	@RequestMapping(value = "/selectCatSubcat", method = RequestMethod.POST)
	public String startATest(@Valid @ModelAttribute("selectCatSubcat") SelectCatSubcat selectCatSubcat, RedirectAttributes redirectAttributes) {

		//@TODO: save information about the test to DB
			
//		SubCategory sce = scs.getSubCategoryById(1);
//		Collection<Question> listQuestions = sce.getQuestionCollection();
//		List<Question> list = new ArrayList<Question>(listQuestions);	
//		Collections.shuffle(list);
		
//		List<Question> listS = scs.getFirst5Q(11);
		
		/*
		 * 1. Get SubCategory list base on student selected in /selectCatSubcat page
		 * 2. Travel from each SubCategory, select random 20 questions to a list
		 * 3. Show the first question to student
		 */
		int firstQuestion = 1;
		//redirect to start a test page
		redirectAttributes.addFlashAttribute("selectCatSubcat", selectCatSubcat);
		return "redirect:/test/start/" + selectCatSubcat.getSubCatId().get(0) + "/" + firstQuestion;
	}	
	
	@RequestMapping(value = "/start/{subCatId}/{questionId}", method = RequestMethod.GET)
	public String startTest(@PathVariable("subCatId") int subCatId, @PathVariable("questionId") int questionId, 
			@ModelAttribute("selectCatSubcat") SelectCatSubcat selectCatSubcat, Model model) {
		return "testStart";
	}
	
	@RequestMapping(value = "/start/{subCatId}/{questionId}", method = RequestMethod.POST)
	public String onGoingTest(@PathVariable("subCatId") int subCatId, @PathVariable("questionId") int questionId, 
			@ModelAttribute("selectCatSubcat") SelectCatSubcat selectCatSubcat, Model model) {
		/*
		 * 1. Save the student's answer to DB
		 * 2. Continue to the next question
		 */
		return "testStart";
	}
}
