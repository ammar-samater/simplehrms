/**
 * 
 */
package com.simplehrms.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplehrms.entities.Employee;
import com.simplehrms.exceptions.BadRequestException;
import com.simplehrms.exceptions.GeneralException;
import com.simplehrms.exceptions.ResourceNotFoundException;
import com.simplehrms.repositories.CityRepository;
import com.simplehrms.repositories.CountryRepository;
import com.simplehrms.repositories.EmployeeRepository;

/**
 * @author Ammar Samater
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	@GetMapping(path = "/employees")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}

	@GetMapping(path = "/employees/{id}")
	public @ResponseBody Employee getEmployeeById(@PathVariable Long id) {
		try {
			return employeeRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("Unable to find an employee with id " + id);
		} catch (Exception e) {
			throw new GeneralException("Internal error");
		}
	}

	@PostMapping(path = "/employees")
	public @ResponseBody String addEmployee(@RequestBody Employee employee) {
		try {
			employeeRepository.save(employee);
			return "employees/" + employee.getId();
		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) {
				throw new BadRequestException("employee not added due to constraint violation");
			} else {
				throw e;
			}
		}
	}

	@DeleteMapping(path = "/employees/{id}")
	public @ResponseBody void deleteEmployee(@PathVariable Long id) {
		try {
			employeeRepository.deleteById(id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Unable to find an employee with id " + id);
		}

	}

	@PutMapping(path = "/employees/{id}")
	public @ResponseBody String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		if (employee.getId() == null)
			throw new BadRequestException("employee id must be included to performe update");
		if (employee.getId() != id)
			throw new BadRequestException("employee id in request does not match the employee id in url");
		try {
			employee = employeeRepository.save(employee);
			return "/employees/" + employee.getId();
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestException("employee not updated due to constraint violation");
		}
	}

	@GetMapping(path = "/employees/create")
	public String getAddEmployeeForm(Model model) {
		model.addAttribute("countries", countryRepository.findAll());
		return "forms/add-employee-form";
	}

	@Transactional
	@GetMapping(path = "/employees/{id}/update")
	public String getUpdateEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		model.addAttribute("countries", countryRepository.findAll());
		model.addAttribute("cities", cityRepository.findByCountry(employee.getAddress().getCity().getCountry()));
		return "forms/update-employee-form";
	}

}
