package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
import com.example.demo.form.StaffRegForm;
public interface StaffService {
	List<Staff> getAllStaffs();
	
	Staff saveStaff(StaffRegForm staffRegForm );
	
	Staff getStaffById(Long id);
	
	Staff updateStaff(StaffRegForm staffRegForm);
	
	void deleteStaffById(Long id);
	
	
	
	
	
}
