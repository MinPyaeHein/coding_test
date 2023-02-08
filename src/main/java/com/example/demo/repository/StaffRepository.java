package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Department;
import com.example.demo.entity.Staff;
public interface StaffRepository extends JpaRepository<Staff, Long>{
	List<Staff> findByEmail(String email);
	
	@Query(   value = "SELECT * from staff where name=:name", 
			  nativeQuery = true)
	Staff findByName(String name);
	
	
}
