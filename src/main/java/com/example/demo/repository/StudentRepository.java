package com.example.demo.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;



public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query(   value = "SELECT * FROM Students s WHERE s.mail_status=:mailStatus", 
			  nativeQuery = true)
	List<Student> findAllStudentsByMailStatus(boolean mailStatus);
	/* @Query("insert into Students (id,name,email,password,mail_status) VALUES (null,?2,?3,?4,?5)", nativeQuery = true)
	  void insertToStudent(String name,String email,String password,boolean b);*/
}
