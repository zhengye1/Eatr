package com.vincent.eatr.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Restaurant")
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 5167537132485590289L;

	@Id
	@Column(name = "Restaurant_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Restaurant_Name")
	private String restaurant_name;

	@Column(name = "Description")
	private String description;

	@Column(name = "Phone_Number")
	private String phone;

	@JoinColumn(name = "Address_ID")
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="Restaurant_Category",
			joinColumns=@JoinColumn(name="Restaurant_ID", referencedColumnName="Restaurant_ID"),
			inverseJoinColumns=@JoinColumn(name="Category_ID", referencedColumnName="Category_ID"))
	private List<Category> category;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
}
