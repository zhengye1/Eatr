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
@Table(name = "Restaurant")
public class Restaurant implements Serializable {

  private static final long serialVersionUID = 5167537132485590289L;

  @Id
  @Column(name = "Restaurant_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Restaurant_Name")
  private String restaurantName;

  @Column(name = "Description")
  private String description;

  @Column(name = "Phone_Number")
  private String phone;

  @JoinColumn(name = "Address_ID")
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
  @JoinTable(name = "Restaurant_Category",
      joinColumns = @JoinColumn(name = "Restaurant_ID", referencedColumnName = "Restaurant_ID"),
      inverseJoinColumns = @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID"))
  private List<Category> category;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Restaurant other = (Restaurant) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (category == null) {
      if (other.category != null) {
        return false;
      }
    } else if (!category.equals(other.category)) {
      return false;
    }
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (phone == null) {
      if (other.phone != null) {
        return false;
      }
    } else if (!phone.equals(other.phone)) {
      return false;
    }
    if (restaurantName == null) {
      if (other.restaurantName != null) {
        return false;
      }
    } else if (!restaurantName.equals(other.restaurantName)) {
      return false;
    }
    return true;
  }
}
