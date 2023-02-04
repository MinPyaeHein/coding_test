package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.LoanRecord;
import com.example.demo.entity.Student;


public interface LoanRecordService {
	List<LoanRecord> getAllLoanRecords();
	
	LoanRecord saveLoanRecord(LoanRecord loanRecord);
	
	LoanRecord getLoanRecordById(Long id);
	
	LoanRecord updateLoanRecord(LoanRecord loanRecord);
	
	void deleteLoanRecordById(Long id);
	
	
}
