package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.common.DatatableModelBean;
import com.example.demo.common.GenericService;
import com.example.demo.common.Util;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Controller
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	  @RequestMapping(value = "/departmentManagement", method = RequestMethod.GET)
	  public String showWelcomePage() {
	        
	        return "departments";
	  }


	@RequestMapping(value = "/getDeptlList", headers = { "Accept=application/json" })
	public @ResponseBody List<Department> listDepartments(HttpServletRequest request) {
		
		GenericService<List<Department>> result = this.departmentService.searchByCriteria(request);
	
		return result.getDatum();
	}

	
	
	@PostMapping("/insertDepartment")
	@ResponseBody
	public String saveDepartment(@ModelAttribute("insertDepartment") Department department) {
		 department=departmentService.saveDepartment(department);
		 return "saved";
	}
		
	@GetMapping("/departments/edit/{id}")
	@ResponseBody
	public Department editGroup(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}


	@PatchMapping("/updateDepartment")
	@ResponseBody
	public String updateDepartment(@ModelAttribute("updateDepartment")Department department) {
		departmentService.updateDepartment(department);
		return "success";	
	}
	

	
	@DeleteMapping("/departments/{id}")
	@ResponseBody
	public String deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
		return "success";
	}
	
	
}
