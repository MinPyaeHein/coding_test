package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Department;
import com.example.demo.entity.Page;
import com.example.demo.entity.Staff;
import com.example.demo.entity.StaffPage;
import com.example.demo.form.StaffRegForm;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.PageService;
import com.example.demo.service.StaffService;
@Controller
public class StaffController {
	private StaffService staffService;
	private PageService pageService;
	private DepartmentService departmentService;
	
	public StaffController(StaffService staffService,PageService pageService,DepartmentService departmentService) {
		super();
		this.staffService = staffService;
		this.pageService=pageService;
		this.departmentService=departmentService;
	}
	
	@GetMapping("/staffs")
	public String listStaffs(Model model) {
		System.out.println("get staff page");
		List<Staff> staffs=staffService.getAllStaffs();
	   System.out.println("get staff page"+staffs.size());
	   //get AllPages by staff id
		
		//System.out.println(pages.size());
		//get all Department by staff id
		List<Department> departments=departmentService.getDepartmentByStaffId(Long.parseLong("7"));
	//	System.out.println(departments.size());
		List<StaffRegForm> staffRegForms=new ArrayList<>();
		for (Staff s:staffs) {
			StaffRegForm staffRegForm=new StaffRegForm();
			staffRegForm.setStaffId(s.getStaffId()+"");
			staffRegForm.setEmail(s.getEmail());
			staffRegForm.setPassword(s.getPassword());
			staffRegForm.setGroup(s.getGroup());
			List<Page> pages=pageService.getPagetByStaffId(Long.parseLong(s.getStaffId()+""));
			staffRegForm.setListPages(pages);
			staffRegForm.setListDepartments(departments);
		}
		
		
		
		model.addAttribute("staffs",staffs );
		return "staffs";
	}
	
	@GetMapping("/deleteStaffPath")
	public String deleteStaff(Model model) {
		System.out.println("Delete Staff");
		staffService.deleteStaffById(Long.parseLong("7"));
		
		
		return "staffs";
	}
	
	 @RequestMapping(value = "/staffManagement", method = RequestMethod.GET)
	  public String showWelcomePage() {
	        
	        return "staff";
	  }
	
	@RequestMapping(value = "/getStaffList", headers = { "Accept=application/json" })
	public @ResponseBody List<Staff> getStaffList() {
		
		return staffService.getAllStaffs();

	}
	

	@PostMapping("/insertStaff")
	@ResponseBody
	public String saveStaff(@ModelAttribute("insertStaff") StaffRegForm staffRegForm) {
		staffService.saveStaff(staffRegForm);
		return "saved";
	}
	
	@GetMapping("/staffs/edit/{id}")
	public String editStaffForm(@PathVariable Long id,Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "edit_staff";
	}

	@GetMapping("/updateStaff")
	@ResponseBody
	public String updateStaff(
			@ModelAttribute("updateStaff")StaffRegForm staffRegForm,Model model) {
		
		staffService.updateStaff(staffRegForm);
		return "updated";		
	}

	
	@GetMapping("/staff/edit/{id}")
	@ResponseBody
	public Staff editStaffForm(@PathVariable Long id) {
		return staffService.getStaffById(id);
		 
	}


	
	@DeleteMapping("/staff/{id}")
	@ResponseBody
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteStaffById(id);
		return "deleted";
	}
	
}
