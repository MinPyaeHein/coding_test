package com.example.demo.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.common.GenericService;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
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

	@Override
	public GenericService<List<Department>> searchByCriteria(HttpServletRequest request) {
		GenericService<List<Department>> result = new GenericService<List<Department>>();
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");

			List<Department> deptList = getAllDepartments();
			int totalRecord = deptList.size();

		
			result.success(deptList);
		} catch (Exception ex) {
			result.fail(ex, ex.getMessage());
		}
		return result;
	}

	@Override
	public List<Department> getDepartmentByStaffId(Long id) {
	
		return departmentRepository.findDepartmentByStaffId(id);
	}

}
