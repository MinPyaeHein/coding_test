package com.example.demo.controller;

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

import com.example.demo.entity.Department;
import com.example.demo.entity.Page;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.PageService;
@Controller
public class PageController {

	private PageService pageService;
   public PageController(PageService pageService) {
		super();
		this.pageService = pageService;
	}

	
	@GetMapping("/pages")
	public String listPages(Model model) {
		model.addAttribute("pages", pageService.getAllPages());
		return "pages";
	}
	
	@GetMapping("/pages/new")
	public String createPageForm(Model model) {
		Page page = new Page();
		model.addAttribute("page", page);
		return "create_page";
		
	}
	
	@PostMapping("/pages")
	public String savePage(@ModelAttribute("page") Page page) {
		
		page=pageService.savePage(page);
		 
		return "redirect:/pages";
	}
	
	@GetMapping("/pages/edit/{id}")
	public String editPageForm(@PathVariable Long id, Model model) {
		model.addAttribute("staff", pageService.getPageById(id));
		return "edit_department";
	}

	@PostMapping("/pages/{id}")
	public String updatePage(@PathVariable Long id,
			@ModelAttribute("page")Page page,
			Model model) {
		Page existingPage = pageService.getPageById(id);
		existingPage.setPageId(id);
		existingPage.setPageName(page.getPageName());
		existingPage.setPageDesc(page.getPageDesc());
		existingPage.setPageCode(page.getPageCode());
		pageService.updatePage(existingPage);
		return "redirect:/pages";		
	}
	

	
	@GetMapping("/pages/{id}")
	public String deletePage(@PathVariable Long id) {
		pageService.deletePagetById(id);
		return "redirect:/pages";
	}
	
}
