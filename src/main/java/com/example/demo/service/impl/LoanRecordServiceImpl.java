package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.LoanRecord;
import com.example.demo.entity.Page;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.LoanRecordRepository;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.LoanRecordService;
import com.example.demo.service.PageService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;


@Service
public class LoanRecordServiceImpl implements LoanRecordService{
	@Autowired
	private LoanRecordRepository loanRecordRepository;
	
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
