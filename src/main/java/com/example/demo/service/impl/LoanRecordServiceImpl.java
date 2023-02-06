package com.example.demo.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.LoanRecord;
import com.example.demo.entity.Staff;
import com.example.demo.form.LoanRecordForm;
import com.example.demo.repository.LoanRecordRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.LoanRecordService;
import com.example.demo.service.StaffService;
@Service
public class LoanRecordServiceImpl implements LoanRecordService{
	
	private LoanRecordRepository loanRecordRepository;
	private StaffService staffService;
	private DepartmentService departmentService;
	
	public LoanRecordServiceImpl(LoanRecordRepository loanRecordRepository,
			                      StaffServiceImpl staffService,
			                      DepartmentService departmentService) {
		super();
		this.loanRecordRepository = loanRecordRepository;
		this.staffService=staffService;
		this.departmentService=departmentService;
	}
	@Override
	public List<LoanRecord> getAllLoanRecords() {
		 return   loanRecordRepository.findAll();
	}
	@Override
	public LoanRecord saveLoanRecord(LoanRecordForm loanRecordForm) throws ParseException {
		LoanRecord loanRecord=new LoanRecord();
		loanRecord.setPeriod(loanRecordForm.getPeriod());
		loanRecord.setAddress(loanRecordForm.getAddress());
		loanRecord.setAmount(loanRecordForm.getAmount());
		
		Date appDate=new SimpleDateFormat("dd/MM/yyyy").parse(loanRecordForm.getApplyDate());  
		loanRecord.setApplyDate(appDate);
		loanRecord.setCreateAt(new Date());
		loanRecord.setLoanType(loanRecordForm.getLoanType());
		Staff staff=staffService.getStaffById(Long.parseLong(loanRecordForm.getStaffId()));
		List<Department> departments=departmentService.getDepartmentByStaffId(staff.getStaffId());
		if(departments!=null) {
		Department department=departments.get(0);
		loanRecord.setDepartment(department);}
		System.out.println("User="+staff.getName()); 
		
		loanRecord.setStaff(staff);
		return loanRecordRepository.save(loanRecord);
	}
	 
	@Override
	public LoanRecord getLoanRecordById(Long id) {
		return loanRecordRepository.findById(id).get();
	}
	@Override
	public LoanRecord updateLoanRecord(LoanRecordForm loanRecordForm)throws ParseException  {
		LoanRecord loanRecord=getLoanRecordById(Long.parseLong(loanRecordForm.getStaffId()));
		loanRecord.setPeriod(loanRecordForm.getPeriod());
		loanRecord.setAddress(loanRecordForm.getAddress());
		loanRecord.setAmount(loanRecordForm.getAmount());
		Date appDate=new SimpleDateFormat("dd/MM/yyyy").parse(loanRecordForm.getApplyDate());  
		loanRecord.setApplyDate(appDate);
		loanRecord.setUpdateAt(new Date());
		loanRecord.setLoanType(loanRecordForm.getLoanType());
		Staff staff=staffService.getStaffById(Long.parseLong(loanRecordForm.getStaffId()));
		loanRecord.setStaff(staff);
		return loanRecordRepository.save(loanRecord);
	}
	@Override
	public void deleteLoanRecordById(Long id) {
		loanRecordRepository.deleteById(id);	
		
	}
	


}
