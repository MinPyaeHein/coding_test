package com.example.demo.service;



import java.text.ParseException;
import java.util.List;
import com.example.demo.entity.LoanRecord;
import com.example.demo.form.LoanRecordForm;


public interface LoanRecordService {
	List<LoanRecord> getAllLoanRecords();
	
	LoanRecord saveLoanRecord(LoanRecordForm LoanRecordForm)throws ParseException ;
	
	LoanRecord getLoanRecordById(Long id);
	
	LoanRecord updateLoanRecord(LoanRecordForm LoanRecordForm)throws ParseException ;
	
	void deleteLoanRecordById(Long id);
	
	
}
