/**
 * 
 */
package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.simplehrms.entities.Employee;
import com.simplehrms.exceptions.BadRequestException;
import com.simplehrms.exceptions.EntityNotFoundException;
import com.simplehrms.jsonview.View;
import com.simplehrms.repositories.EmployeeRepository;

/**
 * @author Ammar Samater
 *
 */

// ResourceNotFoundException
// DataIntegrityViolationException
// HttpMessageNotReadableException
// EmptyResultDataAccessException

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@JsonView(View.Summary.class)
	@GetMapping(path = "/employees")
	public Iterable<Employee> getAllEmployees() throws EntityNotFoundException{
		return employeeRepository.findAll();
	}

	@GetMapping(path = "/employees/{id}")
	@JsonView(View.Full.class)
	@Transactional
	public Employee getEmployeeById(@PathVariable Long id) throws EntityNotFoundException {
		Employee employee = employeeRepository.findById(id).get();
		employee.getEducationLevel().size();
		employee.getCompetencies().size();
		employee.getAddress().getCity().getCountry().getName();
		return employee;
	}

	@PostMapping(path = "/employees")
	@ExceptionHandler(RuntimeException.class)
	public String addEmployee(@RequestBody Employee employee) {
	
			employeeRepository.save(employee);
			return "employees/" + employee.getId();
	}

	@DeleteMapping(path = "/employees/{id}")
	@ExceptionHandler(RuntimeException.class)
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}

	@PutMapping(path = "/employees/{id}")
	@ExceptionHandler(RuntimeException.class)
	public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		
		employee = employeeRepository.save(employee);
		return "/employees/" + employee.getId();
	}

}
