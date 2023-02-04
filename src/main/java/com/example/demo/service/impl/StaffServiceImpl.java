package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;


@Service
public class StaffServiceImpl implements StaffService{
	@Autowired
	private StaffRepository staffRepository;
	@Override
	public List<Staff> getAllStaffs() {
	    return   staffRepository.findAll();
	}
	@Override
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	@Override
	public Staff getStaffById(Long id) {
		return staffRepository.findById(id).get();
	}
	@Override
	public Staff updateStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	@Override
	public void deleteStaffById(Long id) {
		staffRepository.deleteById(id);	
		
	}
	


}
