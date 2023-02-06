package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{
	@Query(   value = "SELECT p.page_id,p.page_name,p.page_code,p.page_desc FROM Page p,staff_page u WHERE p.page_id=u.page_id and u.staff_id=:staffId", 
			  nativeQuery = true)
	List<Page> findPageByStaffId(Long staffId);
}
