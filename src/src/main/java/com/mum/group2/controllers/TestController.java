package com.mum.group2.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.group2.Utils;
import com.mum.group2.bean.SelectCatSubcat;
import com.mum.group2.bean.UserTest;
import com.mum.group2.domain.Category;
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

		List<Category> listCat = cs.findAllCategories();
		JSONArray jsonObject = JSONArray.fromObject( listCat );
		model.addAttribute("categories", listCat);
		model.addAttribute("categoriesJSON", jsonObject);
		model.addAttribute("selectCatSubcat", new SelectCatSubcat());
		return "testSelectCatSubcat";
	}
	
	@RequestMapping(value = "/selectCatSubcat", method = RequestMethod.POST)
	public String startATest(@Valid @ModelAttribute("selectCatSubcat") SelectCatSubcat selectCatSubcat, RedirectAttributes redirectAttributes) {

		//@TODO: save information about the test to DB
			
		//redirect to start a test page
		
//		SubCategory sce = scs.getSubCategoryById(1);
//		Collection<Question> listQuestions = sce.getQuestionCollection();
//		List<Question> list = new ArrayList<Question>(listQuestions);	
//		Collections.shuffle(list);
		
		List<Question> listS = scs.getFirst5Q(11);
		redirectAttributes.addFlashAttribute("selectCatSubcat", selectCatSubcat);
		return "redirect:/test/start";
	}	
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startTest(Model model) {
		
		return "testStart";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public String startNewTest(Model model) {
		
		return "testStart";
	}
}
