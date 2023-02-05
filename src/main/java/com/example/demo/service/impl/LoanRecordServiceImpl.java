package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.LoanRecord;
import com.example.demo.repository.LoanRecordRepository;
import com.example.demo.service.LoanRecordService;
@Service
public class LoanRecordServiceImpl implements LoanRecordService{
	
	private LoanRecordRepository loanRecordRepository;
	
	public LoanRecordServiceImpl(LoanRecordRepository loanRecordRepository) {
		super();
		this.loanRecordRepository = loanRecordRepository;
	}
	@Override
	public List<LoanRecord> getAllLoanRecords() {
		 return   loanRecordRepository.findAll();
	}
	@Override
	public LoanRecord saveLoanRecord(LoanRecord loanRecord) {
		return loanRecordRepository.save(loanRecord);
	}
	@Override
	public LoanRecord getLoanRecordById(Long id) {
		return loanRecordRepository.findById(id).get();
	}
	@Override
	public LoanRecord updateLoanRecord(LoanRecord loanRecord) {
		return loanRecordRepository.save(loanRecord);
	}
	@Override
	public void deleteLoanRecordById(Long id) {
		loanRecordRepository.deleteById(id);	
		
	}
	


}
