package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "staff_role")
public class StaffRole implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_role_id", unique = true, nullable = false)
	private Long staffRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dep_id", nullable = false)
	private Department department;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "page_id", nullable = false)
	private Page page;
	
	}

