package com.vincent.eatr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vincent.eatr.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
