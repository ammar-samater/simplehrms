/**
 * 
 */
package com.simplehrms.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simplehrms.entities.Employee;
import com.simplehrms.repositories.CityRepository;
import com.simplehrms.repositories.CountryRepository;
import com.simplehrms.repositories.DepartmentRepository;
import com.simplehrms.repositories.EmployeeRepository;
import com.simplehrms.repositories.SiteRepository;

/**
 * @author Ammar Samater
 *
 */
@Controller
public class FormController {
	

	
	@Autowired
	private SiteRepository siteRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;
	
	
	@GetMapping(path="/forms/departments/create")
	public String getAddDepartmentForm(Map<String, Object> model) {
		model.put("sites", siteRepository.findAll());
		return "forms/add-department-form";
	}
	
	@GetMapping(path="/forms/departments/{id}/update")
	public String getUpdateDepartmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("department", departmentRepository.findById(id).get());
		model.addAttribute("sites", siteRepository.findAll());
		return "forms/update-department-form";
	}
	
	
	
	@GetMapping(path = "/forms/employees/create")
	public String getAddEmployeeForm(Model model) {
		model.addAttribute("countries", countryRepository.findAll());
		return "forms/add-employee-form";
	}

	@Transactional
	@GetMapping(path = "/forms/employees/{id}/update")
	public String getUpdateEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		model.addAttribute("countries", countryRepository.findAll());
		model.addAttribute("cities", cityRepository.findByCountry(employee.getAddress().getCity().getCountry()));
		return "forms/update-employee-form";
	}
	
//position
	@GetMapping(path = "/forms/positions/create")
	public String getAddPositionForm(Model model) {
		//model.addAttribute("countries", countryRepository.findAll());
		return "forms/add-position-form";
	}

	@Transactional
	@GetMapping(path = "/forms/positions/{id}/update")
	public String getUpdatePositionForm(@PathVariable Long id, Model model) {
		
		//model.addAttribute("employee", employee);
		
		return "forms/update-position-form";
	}
	
	

}
