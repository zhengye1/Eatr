package com.vincent.eatr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.eatr.model.Address;
import com.vincent.eatr.repository.AddressRepository;
import com.vincent.eatr.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	@Override
	public List<Address> findAll() {
		List<Address> result = addressRepository.findAll();
		return result;
	}
	@Override
	public Address findById(long id) {
		Address result = addressRepository.findOne(id);
		return result;
	}
	
	

}
