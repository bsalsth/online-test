package com.mum.group2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.group2.Utils;
import com.mum.group2.bean.UserTest;
import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;
import com.mum.group2.services.TestService;
import com.mum.group2.services.UserService;

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
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showStudentLogin(Model model) {
		Utils.serverTime(model);
		
//		model.addAttribute("testModel", ts.findAll());
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

		return "testSelectCatSubcat";
	}
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startTest(Model model) {
		
		return "testStart";
	}
}
