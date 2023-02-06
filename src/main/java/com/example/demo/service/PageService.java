package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Page;


public interface PageService {
	List<Page> getAllPages();
	
	Page savePage(Page page);
	
	Page getPageById(Long id);
	
	Page updatePage(Page Page);
	
	void deletePagetById(Long id);
	
	List<Page> getPagetByStaffId(Long id);
	
	
}
