/**
 * 
 */
package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplehrms.entities.Employee;
import com.simplehrms.exceptions.BadRequestException;
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



	@GetMapping(path = "/employees")
	public Iterable<Employee> getAllEmployees() {

		return employeeRepository.findAll();

	}

	@GetMapping(path = "/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {

		return employeeRepository.findById(id).get();
	}

	@PostMapping(path = "/employees")
	public String addEmployee(@RequestBody Employee employee) {

		employeeRepository.save(employee);
		return "employees/" + employee.getId();

	}

	@DeleteMapping(path = "/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {

		employeeRepository.deleteById(id);

	}

	@PutMapping(path = "/employees/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		if (employee.getId() == null)
			throw new BadRequestException("employee id must be included to performe update");
		if (employee.getId() != id)
			throw new BadRequestException("employee id in request does not match the employee id in url");

		employee = employeeRepository.save(employee);
		return "/employees/" + employee.getId();

	}

}
