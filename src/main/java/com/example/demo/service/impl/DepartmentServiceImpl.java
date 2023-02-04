package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		  return   departmentRepository.findAll();
	}
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).get();
	}
	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);	
		
	}
	


}
