package com.vincent.eatr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5365669531802381419L;

	@Id
    @Column(name = "Category_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Category_Name", unique=true)
	private String categoryName;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

//	public List<Restaurant> getRestaurants() {
//		return restaurants;
//	}
//
//	public void setRestaurants(List<Restaurant> restaurants) {
//		this.restaurants = restaurants;
//	}
}
