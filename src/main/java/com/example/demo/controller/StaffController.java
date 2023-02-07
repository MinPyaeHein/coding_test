package com.example.demo.controller;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
	
	private StaffRegForm getStaffRegFrom(long id)
	{
		Staff s = this.staffService.getStaffById(id);
		StaffRegForm staffRegForm=new StaffRegForm();
		staffRegForm.setStaffId(s.getStaffId()+"");
		staffRegForm.setEmail(s.getEmail());
		staffRegForm.setName(s.getName());
		staffRegForm.setPassword(s.getPassword());
		staffRegForm.setGroup(s.getGroup());
		List<Page> pages=pageService.getPagetByStaffId(Long.parseLong(s.getStaffId()+""));
		List<Department> departments=departmentService.getDepartmentByStaffId(Long.parseLong(s.getStaffId()+""));
		staffRegForm.setListPages(pages);
		staffRegForm.setListDepartments(departments);
		staffRegForm.setCreateAt(s.getCreateAt());
		staffRegForm.setUpdateAt(s.getUpdateAt());
		
		return staffRegForm;
	
	}
	
	
	private List<StaffRegForm>  getListStaffs() {
		
		List<Staff> staffs=staffService.getAllStaffs();
	 
		List<StaffRegForm> staffRegForms=new ArrayList<>();
		for (Staff s:staffs) {
			StaffRegForm staffRegForm=new StaffRegForm();
			staffRegForm.setStaffId(s.getStaffId()+"");
			staffRegForm.setEmail(s.getEmail());
			staffRegForm.setName(s.getName());
			staffRegForm.setPassword(s.getPassword());
			staffRegForm.setGroup(s.getGroup());
			List<Page> pages=pageService.getPagetByStaffId(Long.parseLong(s.getStaffId()+""));
			List<Department> departments=departmentService.getDepartmentByStaffId(Long.parseLong(s.getStaffId()+""));
			staffRegForm.setListPages(pages);
			staffRegForm.setListDepartments(departments);
			staffRegForm.setCreateAt(s.getCreateAt());
			staffRegForm.setUpdateAt(s.getUpdateAt());
			staffRegForms.add(staffRegForm);
		}
		
		return staffRegForms;
	}
	
	
	@GetMapping("/deleteStaffPath")
	public String deleteStaff(Model model) {
		System.out.println("Delete Staff");
		staffService.deleteStaffById(Long.parseLong("7"));
		
		
		return "staffs";
	}
	
	 @RequestMapping(value = "/staffManagement/{id}", method = RequestMethod.GET)
	  public String showWelcomePage() {
	        
	        return "staff";
	  }
	
	@RequestMapping(value = "/getStaffList", headers = { "Accept=application/json" })
	public @ResponseBody List<StaffRegForm> getStaffList() {
		
		return this.getListStaffs();

	}
	

	@PostMapping("/insertStaff")
	@ResponseBody
	public String saveStaff(@ModelAttribute("insertStaff") StaffRegForm staffRegForm) {
		System.out.println(staffRegForm);
		staffService.saveStaff(staffRegForm);
		return "saved";
	}

	@PatchMapping("/updateStaff")
	@ResponseBody
	public String updateStaff(@ModelAttribute("updateStaff")StaffRegForm staffRegForm) {
	
		System.out.println(staffRegForm);
		
		staffService.updateStaff(staffRegForm);
		return "updated";		
	}
	

	@GetMapping("/staff/edit/{id}")
	@ResponseBody
	public StaffRegForm editStaffForm(@PathVariable Long id) {
		return this.getStaffRegFrom(id);
		 
	}


	
	@DeleteMapping("/staff/{id}")
	@ResponseBody
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteStaffById(id);
		return "deleted";
	}
	
}
