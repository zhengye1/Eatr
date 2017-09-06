package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.vincent.eatr.model.Restaurant;
import com.vincent.eatr.service.RestaurantService;

@RestController
@RequestMapping( value = "/api/restaurant", produces = MediaType.APPLICATION_JSON_VALUE )
public class RestaurantController {
	
	static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	@Autowired
	RestaurantService restaurantService;
	
    @RequestMapping( method = GET)
    public List<Restaurant> loadAll() {
        return this.restaurantService.findAll();
    }
    
    @RequestMapping( method = GET, value= "/page")
    public List<Restaurant> loadAllPage(@PageableDefault(value=1, page=1) Pageable pageable) {
        return this.restaurantService.listAllByPage(pageable).getContent();
    }
    
    @RequestMapping( method = GET, value= "/{restaurantId}")
    public Restaurant loadById(@PathVariable Long restaurantId) {
    	logger.info("Calling loadById with id " + restaurantId);
        return this.restaurantService.findById(restaurantId);
    }
    
	@RequestMapping( method = POST, value = "/")
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant, UriComponentsBuilder ucBuilder){
		this.restaurantService.save(restaurant);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/restaurant/{restaurant}").buildAndExpand(restaurant.getId()).toUri());
		return new ResponseEntity<Restaurant>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = DELETE, value = "/{restaurantId}")
	public ResponseEntity<Restaurant> delete(@PathVariable Long restaurantId){
		Restaurant restaurant = restaurantService.findById(restaurantId);
		if (restaurant == null){
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}
		
		restaurantService.deleteById(restaurantId);
		return new ResponseEntity<Restaurant>(HttpStatus.NO_CONTENT);
	}
}
