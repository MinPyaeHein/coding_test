package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
@Table(name = "loan_record")
public class LoanRecord implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "period")
	private String period;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "address")
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date", nullable = false, length = 10)
	private Date apply_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="set_date", nullable = false, length = 10)
	private Date setDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff;
	
}
