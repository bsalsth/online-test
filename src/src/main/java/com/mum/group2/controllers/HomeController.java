package com.mum.group2.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	@Autowired
	SecurityComponent securityComponent;

	@Autowired
	UserService uService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashBoard(HttpSession session) {
		String role = securityComponent.getUserRole();
		User user = securityComponent.getCurrentUser();
		System.out.println("Current Role : " + role + ", user = : "+ user.getFirstName() + user.getUserId());
		session.setAttribute("currentUserName", user.getFirstName() + " " + user.getLastName());
		session.setAttribute("currentUserId", user.getUserId());
		session.setAttribute("currentRole", role);
		if (role.equals("Admin"))
			return "Admin/index";
		else if (role.equals("Coach"))
			return "Coach/index";
		else
			return "DataManager/index";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String home(Model model) {
		Utils.serverTime(model);

		// "username", "password", "first_name", "last_name", "email"
		User user = new User("Govinda", "password", "first_name", "last_name", "email");
		// usi.save(user);
		//
		// System.out.println("Save a user");
		// model.addAttribute("userModel", usi.findAll());
		return "home";
	}

	@RequestMapping(value = "/addCoachDemo", method = RequestMethod.GET)
	public String addCoach() {
		return "addCoach";
	}

	@RequestMapping(value = "/coachDemo", method = RequestMethod.GET)
	public String coach(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		System.out.println("User Name : " + name);
		model.addAttribute("message", "User Name : " + name);
		model.addAttribute("message1", "User Name : ");
		// getUserDetails();
		return "coaches";
	}

	@RequestMapping(value = "/studentDemo", method = RequestMethod.GET)
	public String studentsDemo() {
		return "students";
	}

	@RequestMapping(value = "/studentDetail", method = RequestMethod.GET)
	public String studentsDetailo() {
		return "studentDetail";
	}

	@RequestMapping(value = "/addStudentDemo", method = RequestMethod.GET)
	public String addStudent() {
		return "addStudent";
	}

	@RequestMapping(value = "/dataManagerDemo", method = RequestMethod.GET)
	public String dmDemo() {
		return "dataManagers";
	}

	@RequestMapping(value = "/addDataManagerDemo", method = RequestMethod.GET)
	public String addDM() {
		return "addDataManager";
	}

	/*
	 * @RequestMapping(value = "/reportsDemo", method = RequestMethod.GET)
	 * public String repDemo(){ return "reports"; }
	 */

	@RequestMapping(value = "/reportDetailDemo", method = RequestMethod.GET)
	public String repDM() {
		return "reportDetail";
	}

	@RequestMapping(value = "/addQuestionDemo", method = RequestMethod.GET)
	public String addQN() {
		return "addQuestion";
	}

	@RequestMapping(value = "/editQuestionDemo", method = RequestMethod.GET)
	public String editQn() {
		return "editQuestion";
	}

	@RequestMapping(value = "/questionsDemo", method = RequestMethod.GET)
	public String qns() {
		return "questions";
	}

}
