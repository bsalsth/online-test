package com.mum.group2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mum.group2.Utils;
import com.mum.group2.bean.BeanUserTest;
import com.mum.group2.domain.Category;
import com.mum.group2.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	//[MT 2017-05-10 11:57]
	@RequestMapping(method = RequestMethod.GET)
	public String showCategories(Model model) {
		List<Category> list = categoryService.findAllCategories();
		model.addAttribute("categoryAdd", new Category());
		model.addAttribute("categoryView", list);
		
		return "categories";
	}
	
	//[MT 2017-05-10 01:26]
	@RequestMapping(value = "/saveACategory", method = RequestMethod.POST)
	public ModelAndView saveCategoryNew(
			@ModelAttribute("category") Category category) {
		categoryService.saveOrUpdateCategory(category);
		return new ModelAndView("redirect:/category");
	}
	
	@RequestMapping("/categoryForm")
	public ModelAndView categoryForm() {
		return new ModelAndView("categoryAdd", "command", new Category());
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because
	 * default request is GET
	 */
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveCategory(
			@ModelAttribute("category") Category category) {
		categoryService.saveOrUpdateCategory(category);
		return new ModelAndView("redirect:/category/viewCategory");
	}

	/* It provides list of categories in model object */
	@RequestMapping("/viewCategory")
	public ModelAndView viewCategory() {
		List<Category> list = categoryService.findAllCategories();
		return new ModelAndView("categoryView", "list", list);
	}

}
