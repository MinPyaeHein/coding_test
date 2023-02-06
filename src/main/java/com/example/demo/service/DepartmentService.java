package com.example.demo.service;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.common.GenericService;
import com.example.demo.data.DeptInfoData;
import com.example.demo.entity.Department;
public interface DepartmentService {
	List<Department> getAllDepartments();
	
	Department saveDepartment(Department department);
	
	Department getDepartmentById(Long id);
	
	Department updateDepartment(Department department);
	
	void deleteDepartmentById(Long id);

	GenericService<List<Department>> searchByCriteria(HttpServletRequest request);
	
	List<Department> getDepartmentByStaffId(Long id);
	
	
}
