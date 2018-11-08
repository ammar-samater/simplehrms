/**
 * 
 */
package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simplehrms.entities.Employee;
import com.simplehrms.repositories.CityRepository;
import com.simplehrms.repositories.CompetencyRepository;
import com.simplehrms.repositories.CountryRepository;
import com.simplehrms.repositories.EmployeeRepository;
import com.simplehrms.repositories.PositionRepository;

/**
 * @author Ammar Samater
 *
 */

@Controller
public class DetailPageController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private PositionRepository positionRepository;

	@Autowired
	private CompetencyRepository competencyRepository;

	@Transactional
	@GetMapping(path = "/employees/id/details")
	public String getUpdateEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		//model.addAttribute("countries", countryRepository.findAll());
		//model.addAttribute("cities", cityRepository.findByCountry(employee.getAddress().getCity().getCountry()));
		//model.addAttribute("employeePositions", employee);
		return "forms/update-employee-form";
	}

}
