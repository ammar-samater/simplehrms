package com.simplehrms.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplehrms.entities.Country;
import com.simplehrms.repositories.CountryRepository;
import com.simplehrms.repositories.EmployeeRepository;


@Controller
public class WelcomeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	




/*	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Country> getAllEmployees() {
		return countryRepository.findAll();
	}
	
	@RequestMapping("/countries")
	public String getCountries() {
		return "contries";
	} */
}