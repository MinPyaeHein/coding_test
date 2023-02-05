package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Group;
import com.example.demo.entity.Page;
import com.example.demo.entity.StaffDepartment;


public interface StaffDepartmentService {
	List<StaffDepartment> getAllstaffDepartments();
	
	void saveStaffDepartment(StaffDepartment staffDepartment);
	
	StaffDepartment getStaffDepartmentById(Long id);
	
	StaffDepartment updateStaffDepartment(StaffDepartment staffDepartment);
	
	void deleteStaffDepartmentById(Long id);
	
	void deleteStaffDepartmentByStaffId(Long id);
	
	
}
