package com.mum.group2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mum.group2.domain.Category;
import com.mum.group2.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

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
		;
		return new ModelAndView("redirect:/categoryView");
	}

	/* It provides list of categories in model object */
	@RequestMapping("/viewCategory")
	public ModelAndView viewCategory() {
		List<Category> list = categoryService.findAllCategories();
		return new ModelAndView("categoryView", "list", list);
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable
	 * puts URL data into variable.
	 */
	@RequestMapping(value = "/editCategory/{catId}")
	public ModelAndView edit(@PathVariable int catId) {
		Category category = categoryService.getCategoryById(catId);

		return new ModelAndView("categoryEdit", "command", category);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editSaveCategory", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("category") Category category) {
		categoryService.saveOrUpdateCategory(category);
		return new ModelAndView("redirect:/categoryView");
	}

	/* It deletes record for the given id in URL and redirects to /categoryView */
	@RequestMapping(value = "/deleteCategory/{catId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int catId) {
		categoryService.deleteCategory(catId);
		logger.info("delete category");
		return new ModelAndView("redirect:/categoryView");
	}
}
