package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.SubCategory;

public interface SubCategoryService {

	public List<SubCategory> findAllSubCategories();

	public void saveOrUpdateSubCategory(SubCategory subCategory);

	public SubCategory getSubCategoryById(int subCategoryId);

	public void deleteSubCategory(int subCategoryId);
}
