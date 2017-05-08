package com.mum.group2.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mum.group2.domain.Answer;
import com.mum.group2.domain.Category;
import com.mum.group2.domain.Question;
import com.mum.group2.domain.SubCategory;
import com.mum.group2.services.AnswerService;
import com.mum.group2.services.CategoryService;
import com.mum.group2.services.ConfigurationService;
import com.mum.group2.services.QuestionService;
import com.mum.group2.services.SubCategoryService;

/**
 * Handles requests for files
 */
@Controller
@RequestMapping("/file")
public class FileController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	CategoryService categoryService;
	@Autowired
	SubCategoryService subcategoryService;
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String setFile(Model model) {
		return "fileLoad";
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public String fileLoad(@RequestParam("file") MultipartFile file, Model model) {

		Workbook workbook = null;
		
		try {
			FileInputStream excelFile = new FileInputStream(convertToFile(file));
	        workbook = new XSSFWorkbook(excelFile);
	        
	        Iterator<Sheet> sheetIterator = workbook.iterator();
	        while (sheetIterator.hasNext()) {
	        	Sheet sheet = sheetIterator.next();
	        	Category category = findOrSaveCategory(sheet.getSheetName());
	        	
	        	Iterator<Row> rowIterator = sheet.iterator();
	        	while (rowIterator.hasNext()) {
		        	Row row = rowIterator.next();
		        	
		        	Iterator<Cell> cellIterator = row.iterator();
		        	int i = 0;
		        	SubCategory subcategory = null;
		        	Question question = null;
		        	while (cellIterator.hasNext()) {
			        	Cell cell = cellIterator.next();
			        	String cellValue = cell.getStringCellValue();
			        	
			        	// SUBCATEGORY
			        	if (i == 0)  {
			        		subcategory = findOrSaveSubcategory(category, cellValue);
			        	// QUESTION
			        	} else if (i == 1) {
			        		question = findOrSaveQuestion(subcategory, cellValue);
			            // 2-6 ANSWER
			        	} else if (i>=2 && i<=6) {
			        		saveAnswer(question, cellValue, row.getCell(8).getStringCellValue(), i);
			        	} else {
			        		// do nothing
			        	}
			        	i++;
			        }
		        }
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return "index";
	}
	
	private Category findOrSaveCategory(String description) {
		Category category = categoryService.findByDescription(description);
		
    	if (category == null) {
    		category = new Category();
    		category.setDescription(description);
    		category = categoryService.saveOrUpdateCategory(category);
    	}
    	
    	return category;
	}
	
	private SubCategory findOrSaveSubcategory(Category category, String description) {
		SubCategory subcategory = subcategoryService.findByDescription(description);
		
		if (subcategory == null) {
			subcategory = new SubCategory();
			subcategory.setCategory(category);
			subcategory.setDescription(description);
    		subcategory = subcategoryService.saveOrUpdateSubCategory(subcategory);
    	}
		
		return subcategory;
	}
	
	private Question findOrSaveQuestion(SubCategory subcategory, String description) {
		Question question = questionService.findByDescription(description);
		
		if (question == null) {
			question = new Question();
			question.setSubcategory(subcategory);
			question.setDescription(description);
			question = questionService.saveOrUpdateQuestion(question);
		}
		
		return question;
	}
	
	private void saveAnswer(Question question, String description, String letterAnswer, int fileColumnIndex) {
		Answer answer = new Answer();
		answer.setQuestion(question);
		answer.setDescription(description);
		int configurationValue = Integer.parseInt(configurationService.findConfigurationValue(letterAnswer));
		answer.setRightAnswer(fileColumnIndex == configurationValue);
		answerService.saveOrUpdateResource(answer);
	}
	
	private File convertToFile(MultipartFile multipartfile) {
		File file = new File(multipartfile.getOriginalFilename());
		
		try {
		    multipartfile.transferTo(file);
		} catch (Exception e) {
		}
		
		return file;
	}
	

}
