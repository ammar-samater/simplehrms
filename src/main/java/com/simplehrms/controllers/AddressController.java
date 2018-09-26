package com.simplehrms.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.Address;
import com.simplehrms.entities.Department;
import com.simplehrms.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	

	@GetMapping(path = "/addresses")
	public @ResponseBody Iterable<Address> getAllAddresses() {
		return addressRepository.findAll();
	}
	
	@GetMapping(path = "/addresses/{id}")
	public @ResponseBody Address getAddressById(@PathVariable Long id) {
		return addressRepository.findById(id).get();
	}

	@PostMapping(path = "/addresses")
	public @ResponseBody String addAddress(@RequestBody Address address) {
		addressRepository.save(address);
		return "departments/" + address.getId();
	}

	@DeleteMapping(path = "/addresses/{id}")
	public @ResponseBody void deleteAddress(@PathVariable Long id) {
		addressRepository.deleteById(id);
		
	}
	
	@PutMapping(path = "/addresses/{id}")
	public @ResponseBody String updateAddress(@RequestBody Address address, @PathVariable Long id) {
		addressRepository.save(address);
		return "/addresses/" +address.getId();
	}
	
}
