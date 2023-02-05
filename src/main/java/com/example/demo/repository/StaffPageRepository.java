package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Page;
import com.example.demo.entity.StaffPage;
public interface StaffPageRepository extends JpaRepository<StaffPage, Long>{
	
}
