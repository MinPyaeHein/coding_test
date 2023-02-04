package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LoanRecord;

public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long>{
	
}
