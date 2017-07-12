package com.vincent.eatr.service;

import java.util.List;
import com.vincent.eatr.model.Address;


public interface AddressService {
	public List<Address> findAll();
	public Address findById(long id);
}
