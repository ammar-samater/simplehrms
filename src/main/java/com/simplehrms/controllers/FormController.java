/**
 * 
 */
package com.simplehrms.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simplehrms.entities.Department;
import com.simplehrms.repositories.CityRepository;
import com.simplehrms.repositories.DepartmentRepository;
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
	
	@GetMapping(path="/forms/add/departments")
	public String getAddDepartmentForm(Map<String, Object> model) {
		model.put("sites", siteRepository.findAll());
		return "forms/add-department-form";
	}
	
	@GetMapping(path="/forms/update/departments/{id}")
	public String getUpdateDepartmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("department", departmentRepository.findById(id).get());
		model.addAttribute("sites", siteRepository.findAll());
		return "forms/update-department-form";
	}
	
	@GetMapping(path="/forms/add/sites")
	public String getSiteForm(Model model) {
		model.addAttribute("cities", new Department());
		return "forms/add-department-form";
	}
	
	
	
	@GetMapping(path="/forms/add/employees")
	public String getAddEmployeeForm(Map<String, Object> model) {
		model.put("departments", departmentRepository.findAll());
		return "forms/add-employee-form";
	}
	

}
