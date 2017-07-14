package com.vincent.eatr.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vincent.eatr.model.Category;
import com.vincent.eatr.service.CategoryService;

@RestController
@RequestMapping( value = "/api/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {


	@Autowired
	private CategoryService categoryService;

	@RequestMapping( method = GET, value= "/all")
	public ResponseEntity<List<Category>> loadAll() {
		List<Category> result =  this.categoryService.findAll();
		if (result.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Category>>(result, HttpStatus.OK);
	}

	@RequestMapping( method = GET, value = "/{categoryId}")
	public Category findById(@PathVariable long categoryId){
		return this.categoryService.findById(categoryId);
	}

	@RequestMapping(value = "/", method = POST)
	public ResponseEntity<Category> add(@RequestBody Category category, UriComponentsBuilder ucBuilder){
		this.categoryService.save(category);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/category/{categoryId}").buildAndExpand(category.getId()).toUri());
		return new ResponseEntity<Category>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{categoryId}", method = DELETE)
	public ResponseEntity<?> deleteCategory(@PathVariable long categoryId){
		Category category = this.categoryService.findById(categoryId);
		if (category == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.categoryService.delete(categoryId);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}
}
