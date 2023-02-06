package com.example.demo.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Staff;
import com.example.demo.form.StaffRegForm;
import com.example.demo.service.StaffService;
@Controller
public class StaffController {
	private StaffService staffService;
	
	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}
	
	 @RequestMapping(value = "/staffManagement", method = RequestMethod.GET)
	  public String showWelcomePage() {
	        
	        return "staff";
	  }
	
	@RequestMapping(value = "/getStaffList", headers = { "Accept=application/json" })
	public @ResponseBody List<Staff> getStaffList() {
		
		return staffService.getAllStaffs();
	}
	

	@PostMapping("/insertStaff")
	@ResponseBody
	public String saveStaff(@ModelAttribute("insertStaff") StaffRegForm staffRegForm) {
		staffService.saveStaff(staffRegForm);
		return "saved";
	}
	
	@GetMapping("/staffs/edit/{id}")
	public String editStaffForm(@PathVariable Long id,Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "edit_staff";
	}

	@GetMapping("/updateStaff")
	@ResponseBody
	public String updateStaff(
			@ModelAttribute("updateStaff")StaffRegForm staffRegForm,Model model) {
		
		staffService.updateStaff(staffRegForm);
		return "updated";		
	}

	
	@GetMapping("/staff/edit/{id}")
	@ResponseBody
	public Staff editStaffForm(@PathVariable Long id) {
		return staffService.getStaffById(id);
		 
	}


	
	@DeleteMapping("/staff/{id}")
	@ResponseBody
	public String deleteStaff(@PathVariable Long id) {
		staffService.deleteStaffById(id);
		return "deleted";
	}
	
}
