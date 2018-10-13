/**
 * 
 */
package com.simplehrms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplehrms.entities.Department;
import com.simplehrms.repositories.DepartmentRepository;

/**
 * @author Ammar Samater
 *
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	


	@GetMapping(path = "/departments")
	public @ResponseBody Iterable<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	@GetMapping(path = "/departments/{id}")
	public @ResponseBody Department getDepartmentById(@PathVariable Long id) {
		return departmentRepository.findById(id).get();
	}

	@PostMapping(path = "/departments")
	public @ResponseBody String addDepartment(@RequestBody Department department) {
		departmentRepository.save(department);
		return "departments/" + department.getId();
	}

	@DeleteMapping(path = "/departments/{id}")
	public @ResponseBody void deleteDepartment(@PathVariable Long id) {
		departmentRepository.deleteById(id);
		
	}
	
	@PutMapping(path = "/departments/{id}")
	public @ResponseBody String updateDepartment(@RequestBody Department department, @PathVariable Long id) {
		departmentRepository.save(department);
		return "/departments/" + department.getId();
	}
	


}
