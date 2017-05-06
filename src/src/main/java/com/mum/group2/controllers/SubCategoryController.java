package com.mum.group2.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mum.group2.domain.Category;
import com.mum.group2.domain.SubCategory;
import com.mum.group2.services.CategoryService;
import com.mum.group2.services.SubCategoryService;

@Controller
@RequestMapping("/subCategory")
public class SubCategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService subCategoryService;

	@RequestMapping(value = "/subCategoryForm", method = RequestMethod.GET)
	public String subCategoryForm(Model model) {
		model.addAttribute("command", new SubCategory());
		return "subCategoryAdd";
	}

	@ModelAttribute("categoryMap")
	public Map<Integer, String> getCategoryMap() {
		List<Category> list = categoryService.findAllCategories();
		Map<Integer, String> categoryMap = new HashMap<Integer, String>();
		for (Category category : list) {
			categoryMap.put(category.getCatId(), category.getDescription());
		}

		return categoryMap;
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because
	 * default request is GET
	 */
	@RequestMapping(value = "/saveSubCategory", method = RequestMethod.POST)
	public ModelAndView saveCategory(
			@ModelAttribute("subCategory") SubCategory subCategory) {
		subCategoryService.saveOrUpdateSubCategory(subCategory);
		return new ModelAndView("redirect:/subCategory/viewSubCategory");
	}

	/* It provides list of categories in model object */
	@RequestMapping("/viewSubCategory")
	public ModelAndView viewCategory() {
		List<SubCategory> list = subCategoryService.findAllSubCategories();
		return new ModelAndView("subCategoryView", "list", list);
	}

}
