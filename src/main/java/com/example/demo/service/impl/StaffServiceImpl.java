package com.example.demo.service.impl;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Group;
import com.example.demo.entity.Page;
import com.example.demo.entity.Staff;
import com.example.demo.entity.StaffDepartment;
import com.example.demo.entity.StaffPage;
import com.example.demo.form.StaffRegForm;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.StaffPageRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.PageService;
import com.example.demo.service.StaffDepartmentService;
import com.example.demo.service.StaffPageService;
import com.example.demo.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService{
	

	private StaffDepartmentService staffDepartmentService;
	
	public StaffServiceImpl(StaffDepartmentService staffDepartmentService, PageService pageService,
			DepartmentService departmentServic, StaffPageService staffPageService, StaffRepository staffRepository) {
		super();
		this.staffDepartmentService = staffDepartmentService;
		this.pageService = pageService;
		this.departmentServic = departmentServic;
		this.staffPageService = staffPageService;
		this.staffRepository = staffRepository;
	}
	private PageService pageService;

	private DepartmentService departmentServic;

	private StaffPageService staffPageService;

	private StaffRepository staffRepository;
	
	@Override
	public List<Staff> getAllStaffs() {
	    return   staffRepository.findAll();
	}
	@Override
	public Staff saveStaff(StaffRegForm staffRegForm) {
		Staff staff=new Staff();
		
		staff.setName(staffRegForm.getName());
		staff.setEmail(staffRegForm.getEmail());
		staff.setPassword(staffRegForm.getPassword());
		staff.setCreateAt(new Date());
		staff=staffRepository.save(staff);
		Group g=groupService.getGroupById(Long.parseLong("1"));
		
		
		for(String s : staffRegForm.getPages()) {
			Page page=pageService.getPageById(Long.parseLong(s));
			StaffPage staffPage=new StaffPage();
			staffPage.setPage(page);	
			staffPage.setStaff(staff);
			staffPageService.saveStaffPage(staffPage);
		}
		
		for(String d: staffRegForm.getDepartments()) {
			Department department =departmentServic.getDepartmentById(Long.parseLong(d));
			StaffDepartment staffDepartment=new StaffDepartment();
			staffDepartment.setDepartment(department);
			staffDepartment.setStaff(staff);
			staffDepartmentService.saveStaffDepartment(staffDepartment);
		}
	
		return staffRepository.save(staff);
	}
	@Override
	public Staff getStaffById(Long id) {
		return staffRepository.findById(id).get();
	}
	@Override
	public Staff updateStaff(StaffRegForm staffRegForm) {
	Staff staff=getStaffById(Long.parseLong(staffRegForm.getStaffId()));
		
		staff.setName(staffRegForm.getName());
		staff.setEmail(staffRegForm.getEmail());
		staff.setPassword(staffRegForm.getPassword());
		staff.setCreateAt(new Date());
		staff=staffRepository.save(staff);
		
		staffDepartmentService.deleteStaffDepartmentByStaffId(staff.getStaffId());
		
		for(String s : staffRegForm.getPages()) {
			Page page=pageService.getPageById(Long.parseLong(s));
			StaffPage staffPage=new StaffPage();
			staffPage.setPage(page);	
			staffPage.setStaff(staff);
			staffPageService.saveStaffPage(staffPage);
		}
		
		for(String d: staffRegForm.getDepartments()) {
			Department department =departmentServic.getDepartmentById(Long.parseLong(d));
			StaffDepartment staffDepartment=new StaffDepartment();
			staffDepartment.setDepartment(department);
			staffDepartment.setStaff(staff);
			staffDepartmentService.saveStaffDepartment(staffDepartment);
		}
	
		return staffRepository.save(staff);
	}
	@Override
	public void deleteStaffById(Long id) {
		staffRepository.deleteById(id);	
		
	}
	


}
