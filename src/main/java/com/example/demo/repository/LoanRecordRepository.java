package com.example.demo.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.LoanRecord;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;



public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long>{
	
}
