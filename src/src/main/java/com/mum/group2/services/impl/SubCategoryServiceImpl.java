package com.mum.group2.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Question;
import com.mum.group2.domain.SubCategory;
import com.mum.group2.repositories.SubCategoryRepository;
import com.mum.group2.services.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepository;

	@Override
	public List<SubCategory> findAllSubCategories() {
		return subCategoryRepository.findAll();
	}

	@Override
	public SubCategory saveOrUpdateSubCategory(SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}

	@Override
	public SubCategory getSubCategoryById(int subCatId) {
		return subCategoryRepository.findOne(Integer.valueOf(subCatId));
	}

	@Override
	public void deleteSubCategory(int subCatId) {
		subCategoryRepository.delete(Integer.valueOf(subCatId));

	}
//
//	@Override
//	public List<SubCategory> getFirst5Question() {
//		return subCategoryRepository.getFirst5Question();
//	}

	@Override
	public List<Question> getFirstNQuestion(int subCatId, int numQuestion) {
		SubCategory sc = getSubCategoryById(subCatId);
		
		List<Question> collQuestion = new ArrayList<>(sc.getQuestionCollection());
		Collections.shuffle(collQuestion);
		return collQuestion.size() > numQuestion ? 
				collQuestion.subList(0, numQuestion) :
					collQuestion.subList(0, collQuestion.size());
	}
	
	
	@Override
	public SubCategory findByDescription(String description) {
		return subCategoryRepository.findByDescription(description);
	}

	@Override
	public List<SubCategory> getSubCategoriesByCategoryId(int catId) {
		return subCategoryRepository.getSubCategoriesByCategoryId(catId);
	}

}
