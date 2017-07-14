package com.vincent.eatr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vincent.eatr.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findByCategoryName(String categoryName);
}
