/**
 * 
 */
package com.simplehrms.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplehrms.entities.Employee;
import com.simplehrms.repositories.DepartmentRepository;
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
	private DepartmentRepository departmentRepository;
	
	@GetMapping(path="/employees")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping(path="/employees/{id}")
	public @ResponseBody Employee getEmployeeById(@PathVariable Long id) {
		return employeeRepository.findById(id).get();
	}

	
	@PostMapping(path="/employees")
	public @ResponseBody String addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "employees/" + employee.getId();
	}
	
	@DeleteMapping(path="/employees/{id}")
	public @ResponseBody void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		
	}
	
	@PutMapping(path = "/employees/{id}")
	public @ResponseBody String updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		employee = employeeRepository.save(employee);
		return "/employees/" + employee.getId();
	}
	
	@GetMapping(path="/employees/create")
	public String getAddEmployeeForm(Map<String, Object> model) {
		//model.put("sites", siteRepository.findAll());
		return "forms/add-employee-form";
	}
	
	@GetMapping(path="/employees/{id}/update")
	public String getUpdateEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeRepository.findById(id).get());
		//model.addAttribute("departments", departmentRepository.findAll());
		return "forms/update-employee-form";
	}


}
