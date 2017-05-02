package com.mum.group2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mum.group2.domain.User;

@Controller
 
public class LoginController {
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String showLogin(Model model) {
		 
		model.addAttribute("userForm", new User());
		return "login";
	}
	

}
