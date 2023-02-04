package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Student;


public interface DepartmentService {
	List<Department> getAllDepartments();
	
	Department saveDepartment(Department department);
	
	Department getDepartmentById(Long id);
	
	Department updateDepartment(Department department);
	
	void deleteDepartmentById(Long id);
	
	
}
