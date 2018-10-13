package com.simplehrms.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.Identification;
import com.simplehrms.repositories.IdentificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class IdentificationController {

	@Autowired
	private IdentificationRepository identificationRepository;
	

	@GetMapping(path = "/identifications")
	public Iterable<Identification> getAllIdentifications() {
		return identificationRepository.findAll();
	}
	
	@GetMapping(path = "/identifications/{id}")
	public  Identification getIdentificationById(@PathVariable Long id) {
		return identificationRepository.findById(id).get();
	}

	@PostMapping(path = "/identifications")
	public String addIdentification(@RequestBody Identification identification) {
		identificationRepository.save(identification);
		return "identifications/" + identification.getId();
	}

	@DeleteMapping(path = "/identifications/{id}")
	public  void deleteIdentification(@PathVariable Long id) {
		identificationRepository.deleteById(id);
		
	}
	
	@PutMapping(path = "/identifications/{id}")
	public  String updateIdentification(@RequestBody Identification identification, @PathVariable Long id) {
		identificationRepository.save(identification);
		return "/identifications/" +identification.getId();
	}
	
}
