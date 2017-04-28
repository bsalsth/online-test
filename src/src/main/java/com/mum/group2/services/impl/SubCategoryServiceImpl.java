package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void saveOrUpdateSubCategory(SubCategory subCategory) {
		subCategoryRepository.save(subCategory);
	}

	@Override
	public SubCategory getSubCategoryById(int subCategoryId) {
		return subCategoryRepository.findOne(Integer.valueOf(subCategoryId));
	}

	@Override
	public void deleteSubCategory(int subCategoryId) {
		subCategoryRepository.delete(Integer.valueOf(subCategoryId));

	}

}
