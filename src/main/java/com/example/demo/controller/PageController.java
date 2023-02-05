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
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.Page;
import com.example.demo.service.PageService;
@Controller
public class PageController {

	private PageService pageService;
   public PageController(PageService pageService) {
		super();
		this.pageService = pageService;
	}
   
   	@GetMapping("/pageManagement")
	public String pageManagement(Model model) {
		
		return "pages";
	}

	@RequestMapping(value = "/getPageList", headers = { "Accept=application/json" })
	public @ResponseBody List<Page> listPages() {
		return pageService.getAllPages();
	}
	
	@PostMapping("/insertPage")
	@ResponseBody
	public String savePage(@ModelAttribute("insertPage") Page page) {
		
		page=pageService.savePage(page);
		 
		return "saved";
	}
	

	@GetMapping("/page/edit/{id}")
	@ResponseBody
	public Page editPageForm(@PathVariable Long id) {
		return pageService.getPageById(id);
	}
	

	@PatchMapping("/updatePage")
	@ResponseBody
	public String updatePage(@ModelAttribute("updatePage")Page page) {
		pageService.updatePage(page);
		return "updated";		
	}
	
	@DeleteMapping("/page/{id}")
	@ResponseBody
	public String deleteDepartment(@PathVariable Long id) {
		pageService.deletePagetById(id);
		return "success";
	}
}
