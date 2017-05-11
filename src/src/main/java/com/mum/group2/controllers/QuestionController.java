package com.mum.group2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mum.group2.bean.BeanCategory;
import com.mum.group2.domain.Answer;
import com.mum.group2.domain.Category;
import com.mum.group2.domain.Question;
import com.mum.group2.domain.SubCategory;
import com.mum.group2.services.CategoryService;
import com.mum.group2.services.QuestionService;
import com.mum.group2.services.SubCategoryService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/questionForm", method = RequestMethod.GET)
	public String questionForm(Model model) {
	
		List<Category> categoryList = categoryService.findAllCategories();
		model.addAttribute("categoryList", categoryList);
		Question question = new Question();
		List<Answer> answers = new ArrayList<Answer>();
		for (int i = 0; i < 5; i++) {
			answers.add(new Answer());
		}
		question.setAnswers(answers);
		model.addAttribute("question", question);
		List<BeanCategory> beanCategoriesModel = categoryService.getAllCategories(0);
		model.addAttribute("categoriesJSON", JSONArray.fromObject(beanCategoriesModel));

		return "addQuestion";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because
	 * default request is GET
	 */
	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public ModelAndView saveQuestion(
			@ModelAttribute("question") Question question) {
		questionService.saveOrUpdateQuestion(question);
		return new ModelAndView("redirect:/question/viewQuestion");
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable
	 * puts URL data into variable.
	 */
	@RequestMapping(value = "/editQuestion/{questionId}")
	public ModelAndView editQuestion(@PathVariable int questionId) {
		Question question = questionService.getQuestionById(questionId);
		return new ModelAndView("addQuestion", "command", question);
	}

	/* It updates model object. */
	@RequestMapping(value = "/editSaveQuestion", method = RequestMethod.POST)
	public ModelAndView editSaveQuestion(
			@ModelAttribute("question") Question question) {
		questionService.saveOrUpdateQuestion(question);
		return new ModelAndView("redirect:/question/viewQuestion");
	}

	@RequestMapping(value = "/deleteQuestion/{questionId}", method = RequestMethod.GET)
	public ModelAndView deleteQuestion(@PathVariable int questionId) {
		questionService.deleteQuestion(questionId);
		return new ModelAndView("redirect:/question/viewQuestion");
	}

	@RequestMapping("/viewQuestion")
	public ModelAndView viewQuestion() {
		List<Question> list = questionService.findAllQuestions();
		return new ModelAndView("questions", "list", list);
	}

	@RequestMapping(value = "/getSubCategoryList/{id}", method = RequestMethod.GET)
	public @ResponseBody List<SubCategory> getSubCategory(
			@PathVariable("id") Integer id, Model model) {
		return subCategoryService.getSubCategoriesByCategoryId(id);
	}

}
