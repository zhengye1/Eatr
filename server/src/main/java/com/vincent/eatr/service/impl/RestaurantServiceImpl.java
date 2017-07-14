package com.vincent.eatr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vincent.eatr.model.Category;
import com.vincent.eatr.model.Restaurant;
import com.vincent.eatr.repository.CategoryRepository;
import com.vincent.eatr.repository.RestaurantRepository;
import com.vincent.eatr.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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

	@Override
	public void save(Restaurant restaurant) {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<>();
		for (Category c :restaurant.getCategory()){
			Category r = categoryRepository.findByCategoryName(c.getCategoryName());
			if (r != null){
				categories.add(r);
			}
			else{
				categoryRepository.save(c);
				categories.add(c);
			}
		}
		restaurant.setCategory(categories);
		restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteById(Long restaurantId) {
		// TODO Auto-generated method stub
		restaurantRepository.delete(restaurantId);
	}

}
