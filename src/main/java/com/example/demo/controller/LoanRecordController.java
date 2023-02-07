package com.example.demo.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Group;
import com.example.demo.entity.LoanRecord;
import com.example.demo.form.LoanRecordForm;
import com.example.demo.service.GroupService;
import com.example.demo.service.LoanRecordService;
@Controller
public class LoanRecordController {
	private LoanRecordService loanRecordService;
	
	public LoanRecordController(LoanRecordService loanRecordService) {
		super();
		this.loanRecordService = loanRecordService;
	}
	
	@GetMapping("/loanRecords")
	public String listLoanRecords(Model model) throws ParseException {
		List<LoanRecord> loanRecords=loanRecordService.getAllLoanRecordsByDepId(Long.parseLong("5"));
	    System.out.println(loanRecords.size());
	    
		loanRecords=loanRecordService.getAllLoanRecordsByStaffId(Long.parseLong("10"));
		System.out.println(loanRecords.size());
		
		Date appDate=new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2022"); 
		System.out.println(loanRecords.size());
		
		
		loanRecords=loanRecordService.getAllLoanRecordsByAppDate(appDate);
		model.addAttribute("loanRecords", loanRecordService.getAllLoanRecords());
		return "loanRecords";
	}
	
	@GetMapping("/loanRecords/new")
	public String createLoanRecordForm(Model model) {
		LoanRecord loanRecord = new LoanRecord();
		model.addAttribute("loanRecord", loanRecord);
		return "create_loanRecord";
	}
	
	@GetMapping("/loanRecordSavePath")
	public String saveLoanRecord(@ModelAttribute("loanRecordForm") LoanRecordForm loanRecordForm) throws ParseException {
	    loanRecordForm.setStaffId("10");
	    loanRecordForm.setAddress("Dawei");
	    loanRecordForm.setApplyDate("01/07/2022");
	    loanRecordForm.setLoanType("Monthly");
	    loanRecordForm.setPeriod("3");
	    loanRecordForm.setAmount(200);
		LoanRecord s=loanRecordService.saveLoanRecord(loanRecordForm);
		return "redirect:/loanRecords";
	}
	
	@GetMapping("/loanRecords/edit/{id}")
	public String editLoanRecordForm(@PathVariable Long id,Model model) {
		model.addAttribute("loanRecord", loanRecordService.getLoanRecordById(id));
		
		return "edit_loanRecord";
	}

	@GetMapping("/loanRecordUpdPath")
	public String updateLoanRecord(
		@ModelAttribute("loanRecordForm")LoanRecordForm loanRecordForm,Model model) throws ParseException {
	    loanRecordForm.setStaffId("10");
	    loanRecordForm.setAddress("Yango");
	    loanRecordForm.setApplyDate("02/07/2022");
	    loanRecordForm.setLoanType("Monthly");
	    loanRecordForm.setPeriod("4");
		loanRecordService.updateLoanRecord(loanRecordForm);
		
		return "redirect:/loanRecords";		
	}
	

	
	@GetMapping("/loanRecords/{id}")
	public String deleteLoanRecord(@PathVariable Long id) {
		loanRecordService.deleteLoanRecordById(id);
		return "redirect:/loanRecords";
	}
	
}
