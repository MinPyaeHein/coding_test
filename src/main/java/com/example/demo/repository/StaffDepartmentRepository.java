package com.example.demo.repository;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StaffDepartment;
@Repository
public interface StaffDepartmentRepository extends JpaRepository<StaffDepartment, Long>{
    @Modifying
	@Query(value="delete from staff_department b where b.staff_id=:staffId",nativeQuery = true)
	void deleteStaffDepartmentByStaff(@Param("staffId")Long staffId );

	
}
