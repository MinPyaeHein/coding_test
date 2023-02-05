package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.StaffPage;
@Repository
public interface StaffPageRepository extends JpaRepository<StaffPage, Long>{
	    @Modifying
		@Query(value="delete from staff_page where staff_id=:staffId",nativeQuery = true)
		void deleteStaffPageByStaffId(@Param("staffId")Long staffId);
}
