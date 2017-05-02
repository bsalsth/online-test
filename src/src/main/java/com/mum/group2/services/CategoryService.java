package com.mum.group2.services;

import java.util.List;

import com.mum.group2.domain.Category;

public interface CategoryService {
	public List<Category> findAllCategories();
	
	public void saveOrUpdateCategory(Category category);
	
	public Category getCategoryById(int categoryId);

	public void deleteCategory(int categoryId) ;
}
