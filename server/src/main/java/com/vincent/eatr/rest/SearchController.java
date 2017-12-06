package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vincent.eatr.model.Restaurant;
import com.vincent.eatr.service.RestaurantService;

@RestController
@RequestMapping(value = "/api/search", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {

  @Autowired
  RestaurantService restaurantService;

  @RequestMapping(value = "/location", method = GET)
  public List<Restaurant> searchWithCoord(@RequestParam(value = "lat", required = true) float lat,
      @RequestParam(value = "lon", required = true) float lon) {
    System.out.printf("Current Location: %f, %f\n", lat, lon);
    return this.restaurantService.findByLatLon(lat, lon);
  }

  @RequestMapping(value = "", method = GET)
  public List<Restaurant> findByCity(@RequestParam(value = "city", required = true) String city) {
    return this.restaurantService.findByCity(city);
  }
}
