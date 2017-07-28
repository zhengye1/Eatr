package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/api/search", produces = MediaType.APPLICATION_JSON_VALUE )
public class SearchController {
	
	@RequestMapping(value = "/location", method=GET)
	public ResponseEntity<Void> searchWithCoord
	(@RequestParam(value="lat", required = true) float lat,
	 @RequestParam(value="lon", required = true) float lon){
		System.out.printf("VINCENT: Lat:%.6f Lon: %.6f\n", lat, lon);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
