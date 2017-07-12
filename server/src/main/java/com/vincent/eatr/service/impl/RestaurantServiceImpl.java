package com.vincent.eatr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vincent.eatr.model.Address;
import com.vincent.eatr.model.Restaurant;
import com.vincent.eatr.repository.RestaurantRepository;
import com.vincent.eatr.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		List<Restaurant> result = restaurantRepository.findAll();
		return result;
	}

	@Override
	public Restaurant findById(long id) {
		// TODO Auto-generated method stub
		Restaurant result = restaurantRepository.findOne(id);
		return result;
	}

	@Override
	public Page<Restaurant> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll(pageable);
	}

}