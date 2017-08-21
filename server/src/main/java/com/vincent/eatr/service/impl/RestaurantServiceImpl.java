package com.vincent.eatr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vincent.eatr.model.Category;
import com.vincent.eatr.model.City;
import com.vincent.eatr.model.Restaurant;
import com.vincent.eatr.repository.CategoryRepository;
import com.vincent.eatr.repository.CityRepository;
import com.vincent.eatr.repository.RestaurantRepository;
import com.vincent.eatr.service.RestaurantService;
import com.vincent.eatr.util.Util;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CityRepository cityRepository;

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
		for (Category c : restaurant.getCategory()) {
			Category r = categoryRepository.findByCategoryName(c.getCategoryName());
			if (r != null) {
				categories.add(r);
			} else {
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

	@Override
	public List<Restaurant> findByCity(String city) {
		City c = cityRepository.findByCityName(city);
		List<Restaurant> result = restaurantRepository.findByAddressCity(c);
		return result;
	}

	@Override
	public List<Restaurant> findByLatLon(float lat, float lon) {
		List<Restaurant> all = findAll();
		Map<Restaurant, Double> resultMap = new HashMap<>();
		for (Restaurant r : all) {
			float lat2 = r.getAddress().getLatitude();
			float lon2 = r.getAddress().getLongitude();
			double dist = Util.haversine(lat, lon, lat2, lon2);
			System.out.println(dist + "KM with Restaurant " + r);
			if (dist < 15) {
				resultMap.put(r, dist);
			}
		}

		// sorted by distance then rating etc and get the top 3
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Comparator<Map.Entry<Restaurant, Double>> comparator = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				Map.Entry<Restaurant, Double> e1 = (Map.Entry<Restaurant, Double>) o1;
				Map.Entry<Restaurant, Double> e2 = (Map.Entry<Restaurant, Double>) o2;
				if (e1.getValue().equals(e2.getValue())) {
					return e1.getKey().getRestaurant_name().compareToIgnoreCase(e2.getKey().getRestaurant_name());
				}
				return e1.getValue().compareTo(e2.getValue());
			}

		};
		
		List<Map.Entry<Restaurant, Double>> lst = new ArrayList<>(resultMap.entrySet());
		Collections.sort(lst, comparator);
		List<Restaurant> sortedList = new ArrayList<>();
		List<Restaurant> result = new ArrayList<>();
        for(Map.Entry<Restaurant, Double> entry : lst) {
            sortedList.add(entry.getKey());
        }
        if (sortedList.size() <= 3) {
        	return sortedList;
        }
        else {
        	for (int i = 0; i < 3; i++) {
        		result.add(sortedList.get(i));
        	}
        	return result;
        }

	}

}
