package com.simplehrms.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.Address;
import com.simplehrms.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	

	@GetMapping(path = "/addresses")
	public Iterable<Address> getAllAddresses() {
		return addressRepository.findAll();
	}
	
	@GetMapping(path = "/addresses/{id}")
	public  Address getAddressById(@PathVariable Long id) {
		return addressRepository.findById(id).get();
	}

	@PostMapping(path = "/addresses")
	public  String addAddress(@RequestBody Address address) {
		addressRepository.save(address);
		return "departments/" + address.getId();
	}

	@DeleteMapping(path = "/addresses/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressRepository.deleteById(id);
		
	}
	
	@PutMapping(path = "/addresses/{id}")
	public String updateAddress(@RequestBody Address address, @PathVariable Long id) {
		addressRepository.save(address);
		return "/addresses/" +address.getId();
	}
	
}
