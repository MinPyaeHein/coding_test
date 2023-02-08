package com.example.demo.service;



import java.text.ParseException;
import java.util.Date;
import java.util.List;
import com.example.demo.entity.LoanRecord;
import com.example.demo.form.LoanRecordForm;


public interface LoanRecordService {
	
	List<LoanRecord> getAllLoanRecords();
	List<LoanRecord> getAllLoanRecordsByStaffId(Long id);
	List<LoanRecord> getAllLoanRecordsByDepId(Long id);
	List<LoanRecord> getAllLoanRecordsByAppDate(Date date);
	
	LoanRecord saveLoanRecord(LoanRecordForm LoanRecordForm)throws ParseException ;
	
	LoanRecord getLoanRecordById(Long id);
	
	LoanRecord updateLoanRecord(LoanRecordForm LoanRecordForm)throws ParseException ;
	
	void deleteLoanRecordById(Long id);
	
	
}
