package com.example.demo.service;



import java.util.List;
import com.example.demo.entity.StaffRole;


public interface StaffRoleService {
	List<StaffRole> getAllStaffs();
	
	StaffRole saveStaff(StaffRole staffRole);
	
	StaffRole getStaffById(Long id);
	
	StaffRole updateStaff(StaffRole staffRole);
	
	void deleteStaffById(Long id);
	
	
}
