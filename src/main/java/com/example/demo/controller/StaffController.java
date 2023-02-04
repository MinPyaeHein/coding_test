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
import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.excel.ExcelGeneratorUser;
import com.example.demo.excel.ExcelGeneratorStudent;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;



@Controller
public class StaffController {
	
	private StaffService staffService;
	
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	@GetMapping("/staffs")
	public String listStaffs(Model model) {
		model.addAttribute("staffs", staffService.getAllStaffs());
		return "staffs";
	}
	
	@GetMapping("/staffs/new")
	public String createStaffForm(Model model) {
		
		// create student object to hold student form data
		Staff staff = new Staff();
		model.addAttribute("staff", staff);
		return "create_staff";
		
	}
	
	@PostMapping("/staffs")
	public String saveStaff(@ModelAttribute("staff") Staff staff) {
		Staff s=staffService.saveStaff(staff);
		return "redirect:/staffs";
	}
	
	@GetMapping("/staffs/edit/{id}")
	public String editStaffForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "edit_staff";
	}

	@PostMapping("/staffs/{id}")
	public String updateStaff(@PathVariable Long id,
			@ModelAttribute("staff")Staff staff,
			Model model) {
		Staff existingStaff = staffService.getStaffById(id);
		existingStaff.setStaffId(id);
		existingStaff.setName(staff.getName());
		existingStaff.setEmail(staff.getEmail());
		existingStaff.setPassword(staff.getPassword());
		staffService.updateStaff(existingStaff);
		return "redirect:/staffs";		
	}
	

	
	@GetMapping("/staffs/{id}")
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteStaffById(id);
		return "redirect:/staffs";
	}
	
}
