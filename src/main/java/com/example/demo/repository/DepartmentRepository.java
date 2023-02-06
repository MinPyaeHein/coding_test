package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Page;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	@Query(   value = "SELECT d.dep_id,d.dep_name,d.dep_code,d.dep_desc FROM department d,staff_department sd WHERE d.dep_id=sd.dep_id and sd.staff_id=:staffId", 
			  nativeQuery = true)
	List<Department> findDepartmentByStaffId(Long staffId);

}
