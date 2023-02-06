package com.example.demo.repository;




import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoanRecord;
import com.example.demo.entity.Page;
@Repository
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long>{
	@Query(   value = "SELECT * FROM loan_record l WHERE  l.staff_id=:staffId", 
			  nativeQuery = true)
	List<LoanRecord> findLoanRecordByStaffId(Long staffId);
	
	@Query(   value = "SELECT * FROM loan_record l WHERE  l.dep_id=:depId", 
			  nativeQuery = true)
	List<LoanRecord> findLoanRecordByDepId(Long depId);
	
	@Query(   value = "SELECT * FROM loan_record l WHERE  l.apply_date=:date", 
			  nativeQuery = true)
	List<LoanRecord> findLoanRecordByApplyDate(Date date);
	
	
	
}