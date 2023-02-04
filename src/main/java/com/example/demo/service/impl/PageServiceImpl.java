package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Page;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.PageRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.PageService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;


@Service
public class PageServiceImpl implements PageService{
	@Autowired
	private PageRepository pageRepository;
	
	
	@Override
	public List<Page> getAllPages() {
		// TODO Auto-generated method stub
		  return   pageRepository.findAll();
	}
	@Override
	public Page savePage(Page page) {
		return pageRepository.save(page);
	}
	@Override
	public Page getPageById(Long id) {
		return pageRepository.findById(id).get();
	}
	@Override
	public Page updatePage(Page page) {
		return pageRepository.save(page);
	}
	@Override
	public void deletePagetById(Long id) {
		pageRepository.deleteById(id);	
		
	}
	


}
