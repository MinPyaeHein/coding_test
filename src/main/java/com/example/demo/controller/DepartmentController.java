package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
@Controller
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String showWelcomePage(ModelMap model) {
	        
	        return "welcome";
	    }
	
	@GetMapping("/departments")
	public String listDepartments(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartments());
		return "welcome";
	}
	
	@GetMapping("/departments/new")
	public String createDepartmentForm(Model model) {
		
		// create student object to hold student form data
		Department department = new Department();
		model.addAttribute("department", department);
		return "welcome";
		
	}
	
	@PostMapping("/departments")
	public String saveDepartment(@ModelAttribute("department") Department department) {
		
		 department=departmentService.saveDepartment(department);
		 
		return "redirect:/departments";
	}
	
	@GetMapping("/departments/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", departmentService.getDepartmentById(id));
		return "edit_department";
	}

	@PostMapping("/departments/{id}")
	public String updateDepartment(@PathVariable Long id,
			@ModelAttribute("department")Department department,
			Model model) {
		Department existingdepartment = departmentService.getDepartmentById(id);
		existingdepartment.setDepId(id);
		existingdepartment.setDepName(department.getDepName());
		existingdepartment.setDep_desc(department.getDep_desc());
		existingdepartment.setDep_code(department.getDep_code());
		departmentService.updateDepartment(existingdepartment);
		return "redirect:/departments";		
	}
	

	
	@GetMapping("/departments/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
		return "redirect:/departments";
	}
	
}
