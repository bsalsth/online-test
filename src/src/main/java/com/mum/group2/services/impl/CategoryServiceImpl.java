package com.mum.group2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.domain.Category;
import com.mum.group2.repositories.CategoryRepository;
import com.mum.group2.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void saveOrUpdateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(int catId) {
		return categoryRepository.findOne(Integer.valueOf(catId));
	}

	@Override
	public void deleteCategory(int catId) {
		categoryRepository.delete(Integer.valueOf(catId));
	}

}
