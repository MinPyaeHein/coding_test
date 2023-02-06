package com.example.demo.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StaffDepartment;
import com.example.demo.repository.StaffDepartmentRepository;
import com.example.demo.service.StaffDepartmentService;

@Service
public class StaffDepartmentServiceImpl implements StaffDepartmentService{
	
	private StaffDepartmentRepository staffDepartmentRepository;
	
	
	public StaffDepartmentServiceImpl(StaffDepartmentRepository staffDepartmentRepository) {
		super();
		this.staffDepartmentRepository = staffDepartmentRepository;
	}
	@Override
	public List<StaffDepartment> getAllstaffDepartments() {
		  return   staffDepartmentRepository.findAll();
	}
	@Override
	public void saveStaffDepartment(StaffDepartment staffDepartment) {
		 staffDepartmentRepository.save(staffDepartment);
	}
	@Override
	public StaffDepartment getStaffDepartmentById(Long id) {
		return staffDepartmentRepository.findById(id).get();
	}
	@Override
	public StaffDepartment updateStaffDepartment(StaffDepartment staffDepartment) {
		return staffDepartmentRepository.save(staffDepartment);
	}
	@Override
	public void deleteStaffDepartmentById(Long id) {
		staffDepartmentRepository.deleteById(id);	
		
	}
	@Override
	@Transactional
	public void deleteStaffDepartmentByStaffId(Long id) {
		staffDepartmentRepository.deleteStaffDepartmentByStaff(id);
		
	}
	


}
