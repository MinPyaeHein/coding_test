package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Group;
import com.example.demo.entity.Staff;
import com.example.demo.form.StaffRegForm;
import com.example.demo.service.GroupService;
import com.example.demo.service.StaffService;
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
		

		Staff staff = new Staff();
		model.addAttribute("staff", staff);
		return "create_staff";
		
	}
	
	@GetMapping("/staffSavePath")
	public String saveStaff(@ModelAttribute("staff") StaffRegForm staffRegForm) {
		staffRegForm.setName("Min Min");
		staffRegForm.setPassword("234455");
		staffRegForm.setEmail("minpyahein.ucsdawei@gmail.com");
		staffRegForm.setGroupId("1");
		List<String> idList=new ArrayList<>();
		idList.add("1");
		idList.add("2");
		staffRegForm.setPages(idList);
		staffRegForm.setDepartments(idList);
		Staff s=staffService.saveStaff(staffRegForm);
		return "redirect:/staffs";
	}
	
	@GetMapping("/staffs/edit/{id}")
	public String editStaffForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "edit_staff";
	}

	@PostMapping("/staffUpdPath")
	public String updateStaff(@PathVariable Long id,
			@ModelAttribute("staff")StaffRegForm staffRegForm,
			Model model) {
		staffRegForm.setName("Min Min Upd");
		staffRegForm.setPassword("234455");
		staffRegForm.setEmail("minpyahein.ucsdawei@gmail.com");
		staffRegForm.setGroupId("1");
		List<String> idList=new ArrayList<>();
		idList.add("1");
		idList.add("2");
		staffRegForm.setPages(idList);
		staffRegForm.setDepartments(idList);
		staffService.updateStaff(staffRegForm);
		return "redirect:/staffs";		
	}
	

	
	@GetMapping("/staffs/{id}")
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteStaffById(id);
		return "redirect:/staffs";
	}
	
}
