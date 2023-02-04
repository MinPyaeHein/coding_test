package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Page;
import com.example.demo.entity.Student;


public interface PageService {
	List<Page> getAllPages();
	
	Page savePage(Page page);
	
	Page getPageById(Long id);
	
	Page updatePage(Page Page);
	
	void deletePagetById(Long id);
	
	
}
