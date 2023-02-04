package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StaffRole;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.StaffRoleRepository;
import com.example.demo.service.StaffRoleService;
@Service
public class StaffRoleServiceImpl implements StaffRoleService{

	    private DepartmentRepository departmentRepository;
		private PageRepository pageRepository;
		private StaffRoleRepository staffRoleRepository;
	
		public StaffRoleServiceImpl(DepartmentRepository departmentRepository,
				PageRepository pageRepository,
				StaffRoleRepository staffRoleRepository) {
			super();
			this.departmentRepository=departmentRepository;
			this.pageRepository = pageRepository;
			this.staffRoleRepository=staffRoleRepository;}
			
	@Override
	public List<StaffRole> getAllStaffs() {
	   
		return staffRoleRepository.findAll();
	}



	@Override
	public StaffRole saveStaff(StaffRole staffRole) {
	
		return staffRoleRepository.save(staffRole);
	}



	@Override
	public StaffRole getStaffById(Long id) {
		
		return staffRoleRepository.findById(id).get();
	}



	@Override
	public StaffRole updateStaff(StaffRole staffRole) {
		
		return staffRoleRepository.save(staffRole);
	}



	@Override
	public void deleteStaffById(Long id) {
		staffRoleRepository.deleteById(id);
		
	}

}
