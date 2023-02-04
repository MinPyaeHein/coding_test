package com.example.demo.controller;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.excel.ExcelGeneratorUser;
import com.example.demo.excel.ExcelGeneratorStudent;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;



@Controller
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping("/departments")
	public String listDepartments(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartments());
		return "departments";
	}
	
	@GetMapping("/departments/new")
	public String createDepartmentForm(Model model) {
		
		// create student object to hold student form data
		Department department = new Department();
		model.addAttribute("department", department);
		return "create_department";
		
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
		existingdepartment.setDesc(department.getDesc());
		departmentService.updateDepartment(existingdepartment);
		return "redirect:/departments";		
	}
	

	
	@GetMapping("/departments/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
		return "redirect:/departments";
	}
	
}
