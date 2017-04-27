package com.mum.group2.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mum.group2.Utils;
import com.mum.group2.domain.Test;
import com.mum.group2.services.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	TestService ts;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showStudentLogin(@ModelAttribute("testModel") Test t, Model model) {
		Utils.serverTime(model);
		
		model.addAttribute("testModel", ts.findAll());
		return "studentTestFrontPage";
	}

//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public String showSelectCat_Subcat(@ModelAttribute("testModel") Test t, BindingResult result,
//			RedirectAttributes redirectAttributes) {
//		if (result.hasErrors()) {
//			return "products_add";
//		}
//
//		productService.addProduct(newProduct);
//		uploadFile(newProduct);
//		
//		redirectAttributes.addFlashAttribute("newProduct", newProduct);
//		return "redirect:/products/list";
//	}
//	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String listProduct(Model model) {
//		List<Product> products = productService.getList();
//		model.addAttribute("products", products);
//		return "products_list";
//	}
}
