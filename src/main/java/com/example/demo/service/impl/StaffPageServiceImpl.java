package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Page;
import com.example.demo.entity.StaffPage;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.StaffPageRepository;
import com.example.demo.service.PageService;
import com.example.demo.service.StaffPageService;

@Service
public class StaffPageServiceImpl implements StaffPageService{
	
	private StaffPageRepository staffPageRepository;
	
	
	public StaffPageServiceImpl(StaffPageRepository staffPageRepository) {
		super();
		this.staffPageRepository = staffPageRepository;
	}

	
	@Override
	public List<StaffPage> getAllStaffPages() {
		// TODO Auto-generated method stub
		  return   staffPageRepository.findAll();
	}
	@Override
	public StaffPage saveStaffPage(StaffPage page) {
		return staffPageRepository.save(page);
	}
	@Override
	public StaffPage getStaffPageById(Long id) {
		return staffPageRepository.findById(id).get();
	}
	@Override
	public StaffPage updateStaffPage(StaffPage staffPage) {
		return staffPageRepository.save(staffPage);
	}
	@Override
	public void deleteStaffPageById(Long id) {
		staffPageRepository.deleteById(id);	
		
	}
	@Override
	public void deleteStaffPageByStaffId(Long id) {
		// TODO Auto-generated method stub
		
	}
	


}
