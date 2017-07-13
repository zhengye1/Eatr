package com.vincent.eatr.service;

import java.util.List;

import com.vincent.eatr.model.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Category findById(Long id);
	public void save(Category category);
	public void delete(Long id);
}
