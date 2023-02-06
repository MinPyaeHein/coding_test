package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   @GetMapping("/groups")
	public String listGroups(Model model) {
		System.out.println(groupService.getAllGroups().size());
		model.addAttribute("groups", groupService.getAllGroups());
		return "groups";}
   
	@RequestMapping(value = "/getGroupList", headers = { "Accept=application/json" })
	public @ResponseBody List<Group> getGroupList() {
		return groupService.getAllGroups();
	}
	
	@GetMapping("/groups/new")
	public String createGroupForm(Model model) {
		Group group = new Group();
		model.addAttribute("group", group);
		return "create_group";
		
	}
	
	@PostMapping("/groups")
	public String saveGroup(@ModelAttribute("page") Group group) {
		
		group=groupService.saveGroup(group);
		 
		return "redirect:/group";
	}
	
	@GetMapping("/groups/edit/{id}")
	public String editGroupForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", groupService.getGroupById(id));
		return "edit_department";
	}

	@PostMapping("/groups/{id}")
	public String updateGroup(@PathVariable Long id,
			@ModelAttribute("group")Group group,
			Model model) {
		Group existingGroup = groupService.getGroupById(id);
		existingGroup.setGroupId(id);
		existingGroup.setGroupName(group.getGroupName());
		existingGroup.setGroupCode(group.getGroupCode());
	    groupService.updateGroup(existingGroup);
		return "redirect:/groups";		
	}
	

	
	@GetMapping("/groups/{id}")
	public String deleteGroup(@PathVariable Long id) {
		groupService.deleteGroupById(id);
		return "redirect:/groups";
	}
	
}
