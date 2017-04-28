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
	public void saveOrUpdateResource(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(int categoryId) {
		return categoryRepository.findOne(Integer.valueOf(categoryId));
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.delete(Integer.valueOf(categoryId));
	}

}
