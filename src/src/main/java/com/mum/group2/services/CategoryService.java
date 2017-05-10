package com.mum.group2.services;

import java.util.List;

import com.mum.group2.bean.BeanCategory;
import com.mum.group2.domain.Category;

public interface CategoryService {
	public List<Category> findAllCategories();
	
	public Category saveOrUpdateCategory(Category category);
	
	public Category getCategoryById(int catId);

	public void deleteCategory(int catId) ;
	
	public List<BeanCategory> getAllCategories(int minimumQuestionPerSubCat);
	
	public Category findByDescription(String description);
	
}
