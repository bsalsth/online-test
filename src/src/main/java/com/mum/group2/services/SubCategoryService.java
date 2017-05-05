package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Question;
import com.mum.group2.domain.SubCategory;

public interface SubCategoryService {

	public List<SubCategory> findAllSubCategories();

	public void saveOrUpdateSubCategory(SubCategory subCategory);

	public SubCategory getSubCategoryById(int subCatId);

	public void deleteSubCategory(int subCatId);

//	public List<SubCategory> getFirst5Question();
	
	public List<Question> getFirstNQuestion(int subCatId, int numQuestion);
}
