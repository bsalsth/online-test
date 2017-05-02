package com.mum.group2.services.impl;

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
	public void saveOrUpdateSubCategory(SubCategory subCategory) {
		subCategoryRepository.save(subCategory);
	}

	@Override
	public SubCategory getSubCategoryById(int subCatId) {
		return subCategoryRepository.findOne(Integer.valueOf(subCatId));
	}

	@Override
	public void deleteSubCategory(int subCatId) {
		subCategoryRepository.delete(Integer.valueOf(subCatId));

	}

	@Override
	public List<SubCategory> getFirst5Question() {
		return subCategoryRepository.getFirst5Question();
	}

	@Override
	public List<Question> getFirst5Q(int subCatId) {
		// TODO Auto-generated method stub
		return subCategoryRepository.getFirst5Q(subCatId);
	}

}
