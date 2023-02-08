package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanRecordForm {
	private Long loanId;
	private String loanType;
	private String period;
	private Integer amount;
	private String address;
	private String applyDate;
	private String staffId;
	
}
