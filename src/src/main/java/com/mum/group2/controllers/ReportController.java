package com.mum.group2.controllers;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mum.group2.domain.Category;
import com.mum.group2.domain.SubCategory;
import com.mum.group2.domain.Test;
import com.mum.group2.domain.TestQuestion;
import com.mum.group2.domain.User;
import com.mum.group2.services.GradeService;
import com.mum.group2.services.TestService;
import com.mum.group2.services.UserService;

/**
 * Handles requests for reports
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	UserService usi;
	@Autowired
	TestService testService;
	@Autowired
	GradeService gradeService;
	
	private static final String CORRECT = "CORRECT";
	private static final String WRONG = "WRONG";
	private static final String TOTAL = "TOTAL";
	private static final String PERCENTAGE = "PERCENTAGE";
	private static final String GRADE = "GRADE";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String generateReport(Model model, @RequestParam(value = "userId", required = true) String userId,
			 @RequestParam(value = "sessionKey", required = true) String sessionKey) {
		
		User user = usi.get(Integer.parseInt(userId));
		Test test = testService.findByUserAndSessionKey(user, sessionKey);
		
		Map<Category,LinkedHashMap<SubCategory,LinkedHashMap<String,String>>> map = new LinkedHashMap<Category,LinkedHashMap<SubCategory,LinkedHashMap<String,String>>>();
		int prevSubcategoryId = -1;
		
		for (TestQuestion tq : test.getTestQuestions()) {
			Category category = tq.getQuestion().getSubcategory().getCategory();
			if (map.get(category) == null) {
				map.put(category, new LinkedHashMap<SubCategory,LinkedHashMap<String,String>>());
			}
			
			SubCategory subcategory = tq.getQuestion().getSubcategory();
			LinkedHashMap<SubCategory,LinkedHashMap<String,String>> subcategories = map.get(category);
			if (!subcategories.containsKey(subcategory)) {
				subcategories.put(subcategory,new LinkedHashMap<String,String>());
			}
			
			LinkedHashMap<String,String> subcatScoreMap = subcategories.get(subcategory);
			if (prevSubcategoryId != subcategory.getSubCatId()) {
				initializeScoreMap(subcatScoreMap);
			}
			
			if (tq.isResult()) {
				addScore(subcatScoreMap, CORRECT);
			} else {
				addScore(subcatScoreMap, WRONG);
			}
			addScore(subcatScoreMap, TOTAL);
			computeGrade(subcatScoreMap);
			
			prevSubcategoryId = subcategory.getSubCatId();
		}
		
		JSONObject json = new JSONObject();
		json.put("user", user);
		json.put("test", test);
		json.put("score", map);
		json.put("categoryScoreMap", calculateTotal(map));
		
		model.addAttribute("report", json);
		
		return "report";
	}
	
	private void initializeScoreMap(Map<String,String> scoreMap) {
		scoreMap.put(CORRECT, String.valueOf(0));
		scoreMap.put(WRONG, String.valueOf(0));
		scoreMap.put(TOTAL, String.valueOf(0));
		computeGrade(scoreMap);
	}
	
	private void addScore(Map<String,String> scoreMap, String key) {
		String subcatValue = scoreMap.get(key);
	    scoreMap.put(key, String.valueOf(Integer.parseInt(subcatValue) + 1));
	}
	
	private void computeGrade(Map<String,String> scoreMap) {
		Double correct = Double.parseDouble(scoreMap.get(CORRECT));
		Double total = Double.parseDouble(scoreMap.get(TOTAL));
		
		String percentage = (NumberFormat.getPercentInstance()).format(correct/total);
		scoreMap.put(PERCENTAGE, percentage);
		
		if (total == 0) {
		    scoreMap.put(GRADE, gradeService.findGrade(0F));
		} else {
			scoreMap.put(GRADE, gradeService.findGrade(Float.parseFloat(percentage.substring(0,percentage.length()-1))));
		}
		
	}
	
	private Map<String,LinkedHashMap<String,String>> calculateTotal(Map<Category,LinkedHashMap<SubCategory,LinkedHashMap<String,String>>> map) {
		Map<String,LinkedHashMap<String,String>> categoryScoreMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
		
		for (Category category : map.keySet()) {
			LinkedHashMap<SubCategory,LinkedHashMap<String,String>> subcategories = map.get(category);
			int correct = 0;
			int incorrect = 0;
			int total = 0;
			
			for (SubCategory subcategory : subcategories.keySet()) {
				LinkedHashMap<String,String> subcatScoreMap = subcategories.get(subcategory);
				correct += Integer.parseInt(subcatScoreMap.get(CORRECT));
				incorrect += Integer.parseInt(subcatScoreMap.get(WRONG));
			    total += Integer.parseInt(subcatScoreMap.get(TOTAL));
			}
			
			LinkedHashMap<String,String> scoreMap = new LinkedHashMap<String,String>();
			scoreMap.put(CORRECT, String.valueOf(correct));
			scoreMap.put(WRONG, String.valueOf(incorrect));
			scoreMap.put(TOTAL, String.valueOf(total));
			computeGrade(scoreMap);
			
			categoryScoreMap.put(category.getDescription(), scoreMap);
		}
		
		return categoryScoreMap;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(Model model) {
		
		List<Test> tests = testService.getAllOrderByTestDate();
		
		JSONObject json = new JSONObject();
		json.put("list", tests);
		
		model.addAttribute("test", json);
		
		return "reportList";
	}

}
