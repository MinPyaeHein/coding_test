package com.example.demo.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StaffPage;


public interface StaffRoleRepository extends JpaRepository<StaffPage, Long>{
	
}
