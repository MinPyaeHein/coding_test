package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;


public interface StaffService {
	List<Staff> getAllStaffs();
	
	Staff saveStaff(Staff staff);
	
	Staff getStaffById(Long id);
	
	Staff updateStaff(Staff staff);
	
	void deleteStaffById(Long id);
	
	
}
