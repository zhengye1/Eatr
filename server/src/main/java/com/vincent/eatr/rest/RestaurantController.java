package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.eatr.model.Restaurant;
import com.vincent.eatr.service.RestaurantService;

@RestController
@RequestMapping( value = "/api/restaurant", produces = MediaType.APPLICATION_JSON_VALUE )
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
    @RequestMapping( method = GET, value= "/all")
    public List<Restaurant> loadAll() {
        return this.restaurantService.findAll();
    }
    
    @RequestMapping( method = GET, value= "/all/page")
    public List<Restaurant> loadAllPage(@PageableDefault(value=1, page=1) Pageable pageable) {
        return this.restaurantService.listAllByPage(pageable).getContent();
    }
    
    @RequestMapping( method = GET, value= "/{restaurantId}")
    public Restaurant loadById(@PathVariable Long restaurantId) {
        return this.restaurantService.findById(restaurantId);
    }
}
