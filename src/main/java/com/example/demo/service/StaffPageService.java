package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Group;
import com.example.demo.entity.Page;
import com.example.demo.entity.StaffPage;


public interface StaffPageService {
	List<StaffPage> getAllStaffPages();
	
	StaffPage saveStaffPage(StaffPage staffPage);
	
	StaffPage getStaffPageById(Long id);
	
	StaffPage updateStaffPage(StaffPage group);
	
	void deleteStaffPageById(Long id);
	
	void deleteStaffPageByStaffId(Long id);
	
	
}
