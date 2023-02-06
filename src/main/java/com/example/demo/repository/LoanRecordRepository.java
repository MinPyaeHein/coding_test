package com.example.demo.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoanRecord;
import com.example.demo.entity.Page;
@Repository
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long>{
	@Query(   value = "SELECT * FROM loan_record l WHERE and u.staff_id=:staffId", 
			  nativeQuery = true)
	List<Page> findLoanRecordByStaffId(Long staffId);
	
	
	
}