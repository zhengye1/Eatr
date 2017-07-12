package com.vincent.eatr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vincent.eatr.model.Restaurant;


public interface RestaurantService {
	public List<Restaurant> findAll();
	public Restaurant findById(long id);
	Page<Restaurant> listAllByPage(Pageable pageable);
}
