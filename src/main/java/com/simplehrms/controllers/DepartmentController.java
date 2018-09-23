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

import com.simplehrms.entities.Department;
import com.simplehrms.repositories.DepartmentRepository;
import com.simplehrms.repositories.SiteRepository;

/**
 * @author Ammar Samater
 *
 */
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private SiteRepository siteRepository;

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
	
	@GetMapping(path="/departments/add")
	public String getAddDepartmentForm(Map<String, Object> model) {
		model.put("sites", siteRepository.findAll());
		return "forms/add-department-form";
	}
	
	@GetMapping(path="/departments/{id}/update")
	public String getUpdateDepartmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("department", departmentRepository.findById(id).get());
		model.addAttribute("sites", siteRepository.findAll());
		return "forms/update-department-form";
	}

}
