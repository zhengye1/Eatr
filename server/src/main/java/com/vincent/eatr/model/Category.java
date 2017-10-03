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
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 5365669531802381419L;

  @Id
  @Column(name = "Category_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Category_Name", unique = true)
  private String categoryName;


  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
  @JoinTable(name = "Restaurant_Category",
      joinColumns = @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID"),
      inverseJoinColumns = @JoinColumn(name = "Restaurant_ID",
          referencedColumnName = "Restaurant_ID"))
  private List<Restaurant> restaurants;

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

  // public List<Restaurant> getRestaurants() {
  // return restaurants;
  // }
  //
  // public void setRestaurants(List<Restaurant> restaurants) {
  // this.restaurants = restaurants;
  // }
}
