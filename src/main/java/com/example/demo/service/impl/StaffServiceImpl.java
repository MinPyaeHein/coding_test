package com.example.demo.service.impl;


import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Group;
import com.example.demo.entity.Page;
import com.example.demo.entity.Staff;
import com.example.demo.entity.StaffDepartment;
import com.example.demo.entity.StaffDepartmentId;
import com.example.demo.entity.StaffPage;
import com.example.demo.entity.StaffPageId;
import com.example.demo.form.StaffRegForm;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.StaffPageRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.GroupService;
import com.example.demo.service.PageService;
import com.example.demo.service.StaffDepartmentService;
import com.example.demo.service.StaffPageService;
import com.example.demo.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService{
	
	private PageService pageService;
	private DepartmentService departmentServic;
	private StaffRepository staffRepository;
	private StaffDepartmentService staffDepartmentService;
	private StaffPageService staffPageService;
	private GroupService groupService;
	public StaffServiceImpl(StaffDepartmentService staffDepartmentService,
			DepartmentService departmentServic, StaffPageService staffPageService,GroupService groupService,PageService pageService, StaffRepository staffRepository) {
		super();
		this.staffDepartmentService = staffDepartmentService;
		this.departmentServic = departmentServic;
		this.staffPageService = staffPageService;
		this.staffRepository = staffRepository;
		this.groupService=groupService;
		this.pageService=pageService;
	}
	
	
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
		staff.setUpdateAt(new Date());
		Group g=groupService.getGroupById(Long.parseLong(staffRegForm.getGroupId()));
		staff.setGroup(g);
		staff=staffRepository.save(staff);
		
		for(String s : staffRegForm.getPages()) {
			StaffPage staffPage=new StaffPage();
			StaffPageId staffPageId=new StaffPageId();
			staffPageId.setPageId(Long.parseLong(s));
			staffPageId.setStaffId(staff.getStaffId());
			staffPage.setId(staffPageId);
			staffPageService.saveStaffPage(staffPage);
		}
		
		for(String d: staffRegForm.getDepartments()) {
			Department department =departmentServic.getDepartmentById(Long.parseLong(d));
			StaffDepartment staffDepartment=new StaffDepartment();
			StaffDepartmentId staffDepartmentId=new StaffDepartmentId();
			staffDepartmentId.setDepId(department.getDepId());
			staffDepartmentId.setStaffId(staff.getStaffId());
			staffDepartment.setDepartment(department);
			staffDepartment.setId(staffDepartmentId);
			staffDepartmentService.saveStaffDepartment(staffDepartment);
		}
	
		return staff;
	}
	@Override
	public Staff getStaffById(Long id) {
		return staffRepository.findById(id).get();
	}
	
	
	@Override
	public Staff updateStaff(StaffRegForm staffRegForm) {
	Staff staff=getStaffById(Long.parseLong(staffRegForm.getStaffId()));
		System.out.println("staff.getName()"+staff.getName()+"="+staff.getStaffId());
		staff.setName(staffRegForm.getName());
		staff.setEmail(staffRegForm.getEmail());
		staff.setPassword(staffRegForm.getPassword());
		staff.setCreateAt(staff.getCreateAt());
		staff.setUpdateAt(new Date());
		staff=staffRepository.save(staff);
		
		staffDepartmentService.deleteStaffDepartmentByStaffId(staff.getStaffId());
		
		
		for(String d: staffRegForm.getDepartments()) {
			System.out.println(d);

			Department department =departmentServic.getDepartmentById(Long.parseLong(d));
			StaffDepartment staffDepartment=new StaffDepartment();
			StaffDepartmentId staffDepartmentId=new StaffDepartmentId();
			staffDepartmentId.setDepId(department.getDepId());
			staffDepartmentId.setStaffId(staff.getStaffId());
			staffDepartment.setDepartment(department);
			staffDepartment.setId(staffDepartmentId);
			staffDepartmentService.saveStaffDepartment(staffDepartment);
		}
		
		staffPageService.deleteStaffPageByStaffId(staff.getStaffId());
		
		for(String s : staffRegForm.getPages()) {
			Page page=pageService.getPageById(Long.parseLong(s));
			StaffPage staffPage=new StaffPage();
			StaffPageId staffPageId=new StaffPageId();
			staffPageId.setPageId(Long.parseLong(s));
			staffPageId.setStaffId(staff.getStaffId());
			staffPage.setId(staffPageId);
			staffPageService.saveStaffPage(staffPage);
		}
		
		
	
		return staff;
	}
	@Override
	public void deleteStaffById(Long id) {
		staffRepository.deleteById(id);	
		
	}


	
	


}
