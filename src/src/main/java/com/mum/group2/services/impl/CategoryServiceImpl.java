package com.mum.group2.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.group2.bean.BeanCategory;
import com.mum.group2.bean.BeanSubcat;
import com.mum.group2.domain.Category;
import com.mum.group2.domain.SubCategory;
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
	public Category saveOrUpdateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getCategoryById(int catId) {
		return categoryRepository.findOne(Integer.valueOf(catId));
	}

	@Override
	public void deleteCategory(int catId) {
		categoryRepository.delete(Integer.valueOf(catId));
	}

	@Override
	public List<BeanCategory> getAllCategories() {
		List<Category> listCat = findAllCategories();
		
		ArrayList<BeanCategory> retList = new ArrayList<BeanCategory>();
		for(Category cat : listCat) {
			BeanCategory bc = new BeanCategory(cat.getCatId(), cat.getDescription());
			ArrayList<BeanSubcat> listBeanSubcat = bc.getListSubcat();
			
			Collection<SubCategory> listSubcat = cat.getSubCatCollection();
			for (SubCategory subCat : listSubcat) {
				listBeanSubcat.add(new BeanSubcat(subCat.getSubCatId(), subCat.getDescription()));
			}
			retList.add(bc);
		}
		return retList;
	}
	
	
	@Override
	public Category findByDescription(String description) {
		return categoryRepository.findByDescription(description);
	}

}
