package com.mum.group2.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.group2.services.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService ts;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Locale locale, Model model) {

		model.addAttribute("testModel", ts.findAll());
		return "studentTestFrontPage";
	}

}
