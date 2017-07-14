package com.vincent.eatr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.eatr.model.Category;
import com.vincent.eatr.repository.CategoryRepository;
import com.vincent.eatr.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(id);
	}

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.delete(id);
	}

	@Override
	public Category findByName(String categoryName) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryName(categoryName);
	}

}
