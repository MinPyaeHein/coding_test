package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.PageService;
import com.example.demo.service.impl.PageServiceImpl;

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
@Table(name = "staff")
public class Staff implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id", unique = true, nullable = false)
	private Long staffId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "account_status")
	private String accountStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_at", nullable = false, length = 10)
	private Date createAt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updated_at", nullable = false, length = 10)
	private Date updateAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false)
	private Group group;
	
	
}
