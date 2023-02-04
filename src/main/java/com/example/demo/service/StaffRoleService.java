package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
import com.example.demo.entity.StaffRole;
import com.example.demo.entity.Student;


public interface StaffRoleService {
	List<StaffRole> getAllStaffs();
	
	StaffRole saveStaff(StaffRole staffRole);
	
	StaffRole getStaffById(Long id);
	
	StaffRole updateStaff(StaffRole staffRole);
	
	void deleteStaffById(Long id);
	
	
}
