package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Group;
import com.example.demo.entity.Page;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.PageRepository;
import com.example.demo.service.GroupService;
import com.example.demo.service.PageService;

@Service
public class GroupServiceImpl implements GroupService{

	private GroupRepository groupRepository;
	
	
	public GroupServiceImpl(GroupRepository groupRepository) {
		super();
		this.groupRepository = groupRepository;
	}
	
	@Override
	public List<Group> getAllGroups() {
		// TODO Auto-generated method stub
		  return   groupRepository.findAll();
	}
	@Override
	public Group saveGroup(Group page) {
		return groupRepository.save(page);
	}
	@Override
	public Group getGroupById(Long id) {
		return groupRepository.findById(id).get();
	}
	@Override
	public Group updateGroup(Group page) {
		return groupRepository.save(page);
	}
	@Override
	public void deleteGroupById(Long id) {
		groupRepository.deleteById(id);	
		
	}
	


}
