package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.common.GenericService;
import com.example.demo.entity.Department;
import com.example.demo.entity.Group;
import com.example.demo.entity.Page;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.GroupService;
import com.example.demo.service.PageService;
@Controller
public class GroupController {
	
private GroupService groupService;
   public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
   
   @RequestMapping(value = "/groupManagement", method = RequestMethod.GET)
	  public String groupManagement() {
	        
	        return "groups";
	  }

   @RequestMapping(value = "/getGroupList", headers = { "Accept=application/json" })
	public @ResponseBody List<Group> listGroups() {
		return  groupService.getAllGroups();
   }

   @PostMapping("/insertGroup")
	@ResponseBody
	public String saveGroup(@ModelAttribute("insertGroup") Group group) {
		 group=groupService.saveGroup(group);
		 return "saved";
	}
		
	@GetMapping("/group/edit/{id}")
	@ResponseBody
	public Group editGroup(@PathVariable Long id) {
		return groupService.getGroupById(id);
	}


	@PatchMapping("/updateGroup")
	@ResponseBody
	public String updateGroup(@ModelAttribute("updateGroup")Group group) {
		groupService.updateGroup(group);
		return "success";	
	}

	@DeleteMapping("/group/{id}")
	public String deleteGroup(@PathVariable Long id) {
		groupService.deleteGroupById(id);
		return "success";
	}
	
}
