package com.example.demo.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.LoanRecord;
import com.example.demo.form.LoanRecordForm;
import com.example.demo.service.LoanRecordService;
@Controller
public class LoanRecordController {
	private LoanRecordService loanRecordService;
	
	public LoanRecordController(LoanRecordService loanRecordService) {
		super();
		this.loanRecordService = loanRecordService;
	}
	
	 @RequestMapping(value = "/loanManagement", method = RequestMethod.GET)
	  public String loanManagement() {
		
	        return "loans";
	  }

	@RequestMapping(value = "/getLoanList", headers = { "Accept=application/json" })
	public @ResponseBody List<LoanRecord> listLoanRecords() throws ParseException {
		List<LoanRecord> loanRecords=loanRecordService.getAllLoanRecordsByDepId(Long.parseLong("5"));
	    System.out.println(loanRecords.size());
	    
		loanRecords=loanRecordService.getAllLoanRecordsByStaffId(Long.parseLong("10"));
		System.out.println(loanRecords.size());
		
		Date appDate=new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2022"); 
		System.out.println(loanRecords.size());
		
		loanRecords=loanRecordService.getAllLoanRecordsByAppDate(appDate);
		
		return loanRecordService.getAllLoanRecords();
	}
	
	@PostMapping("/insertLoan")
	@ResponseBody
	public String saveLoanRecord(@ModelAttribute("insertLoan") LoanRecordForm loanRecordForm) throws ParseException {
		loanRecordForm.setStaffId("3");
		loanRecordService.saveLoanRecord(loanRecordForm);
		return "success";
	}

	@GetMapping("/loan/edit/{id}")
	@ResponseBody
	public LoanRecord editLoanRecordForm(@PathVariable Long id) {	
		return loanRecordService.getLoanRecordById(id);
	}
	
	@PatchMapping("/updateLoan")
	@ResponseBody
	public String updateLoanRecord(
		@ModelAttribute("loanRecordForm")LoanRecordForm loanRecordForm) throws ParseException {
		
		loanRecordForm.setStaffId("2");
		loanRecordService.updateLoanRecord(loanRecordForm);
		
		return "success";		
	}
	

	
	@DeleteMapping("/loan/{id}")
	@ResponseBody
	public String deleteLoanRecord(@PathVariable Long id) {
		loanRecordService.deleteLoanRecordById(id);
		return "success";
	}
	
}
