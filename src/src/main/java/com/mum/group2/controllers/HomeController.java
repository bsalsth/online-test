package com.mum.group2.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.group2.Utils;
import com.mum.group2.domain.User;
import com.mum.group2.services.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService usi;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String home(Model model) {
		Utils.serverTime(model);

		// "username", "password", "first_name", "last_name", "email"
		User user = new User("Govinda", "password", "first_name", "last_name", "email");
//		usi.save(user);
//		
//		System.out.println("Save a user");
		
		model.addAttribute("userModel", usi.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashBoard(){
		return "index";
	}

	
	@RequestMapping(value = "/addCoachDemo", method = RequestMethod.GET)
	public String addCoach(){
		return "addCoach";
	}
	
	
	@RequestMapping(value = "/coachDemo", method = RequestMethod.GET)
	public String coach(){
		return "coaches";
	}
	
	
	@RequestMapping(value = "/studentDemo", method = RequestMethod.GET)
	public String studentsDemo(){
		return "students";
	}
	

	@RequestMapping(value = "/studentDetail", method = RequestMethod.GET)
	public String studentsDetailo(){
		return "studentDetail";
	}
	
	@RequestMapping(value = "/addStudentDemo", method = RequestMethod.GET)
	public String addStudent(){
		return "addStudent";
	}
	

	@RequestMapping(value = "/dataManagerDemo", method = RequestMethod.GET)
	public String dmDemo(){
		return "dataManagers";
	}
	
	@RequestMapping(value = "/addDataManagerDemo", method = RequestMethod.GET)
	public String addDM(){
		return "addDataManager";
	}
	

	@RequestMapping(value = "/reportsDemo", method = RequestMethod.GET)
	public String repDemo(){
		return "reports";
	}
	
	@RequestMapping(value = "/reportDetailDemo", method = RequestMethod.GET)
	public String repDM(){
		return "reportDetail";
	}
	
	
	@RequestMapping(value = "/addQuestionDemo", method = RequestMethod.GET)
	public String addQN(){
		return "addQuestion";
	}
	
	@RequestMapping(value = "/editQuestionDemo", method = RequestMethod.GET)
	public String editQn(){
		return "editQuestion";
	}
	
	@RequestMapping(value = "/questionsDemo", method = RequestMethod.GET)
	public String qns(){
		return "questions";
	}
	
}
