package com.vincent.eatr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vincent.eatr.model.City;

public interface CityRepository extends JpaRepository<City, Long>{
	City findByCityName(String cityName);
}
