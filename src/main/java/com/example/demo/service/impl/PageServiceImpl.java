package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Page;
import com.example.demo.repository.PageRepository;
import com.example.demo.service.PageService;

@Service
public class PageServiceImpl implements PageService{
	
	private PageRepository pageRepository;
	
	
	public PageServiceImpl(PageRepository pageRepository) {
		super();
		this.pageRepository = pageRepository;
	}
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
	public PageRepository getPageRepository() {
		return pageRepository;
	}
	public void setPageRepository(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}
	


}
