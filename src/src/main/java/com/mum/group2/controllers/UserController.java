package com.mum.group2.controllers;

 
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mum.group2.Utils;
import com.mum.group2.bean.BeanUserTest;
import com.mum.group2.domain.Role;
import com.mum.group2.domain.Test;
import com.mum.group2.domain.User;
import com.mum.group2.services.RoleService;
import com.mum.group2.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private RoleService roleService;
	    
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Model model) {
		 
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		 
		 

        /*if (bindingResult.hasErrors()) {
            return "registration";
        }*/
        
        userService.save(userForm);
        
        return "userDetails";
		 
		//System.out.println("registered");
		 
	}
	@RequestMapping(value = "/showUser/{userName}", method = RequestMethod.GET)
	public String showUser(Model model, @PathVariable("userName") String userName) {
		 
		 User user = new User();
		 user = userService.findByUserName(userName);
		 
		 model.addAttribute("userForm", user);
        
         return "userDetails";
		 
		 
		 
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
	
	@RequestMapping(value = "/reguser/{id1}/{id2}", method = RequestMethod.GET)
	
	public @ResponseBody User setRole(@PathVariable("id1") int userId, @PathVariable("id2") int roleId) {
		
		

		 //System.out.println(roleId +userId);
		
		User user = userService.get(userId);
		Role role = roleService.findOne(roleId);
		user.getRoles().add(role);
		
		/*roles.add(role);
		userForm.setRoles(roles);*/
		user= userService.save(user);
		
		System.out.println(user.getRoles());
		System.out.println(user.getFirstName());
		 
		return user;
	}
	
	
	

}
