package com.vincent.eatr.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincent.eatr.model.Address;
import com.vincent.eatr.service.AddressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping( value = "/api/address", produces = MediaType.APPLICATION_JSON_VALUE )
public class AddressController {

	@Autowired
	private AddressService addressService;
	
    @RequestMapping( method = GET, value= "/all")
    public List<Address> loadAll() {
        return this.addressService.findAll();
    }
    
    @RequestMapping( method = GET, value= "/{addressId}")
    public Address loadById(@PathVariable Long addressId) {
        return this.addressService.findById(addressId);
    }

}
