package com.example.demo.service;



import java.util.List;
import com.example.demo.entity.StaffPage;


public interface StaffRoleService {
	List<StaffPage> getAllStaffs();
	
	StaffPage saveStaff(StaffPage staffRole);
	
	StaffPage getStaffById(Long id);
	
	StaffPage updateStaff(StaffPage staffRole);
	
	void deleteStaffById(Long id);
	
	
}
