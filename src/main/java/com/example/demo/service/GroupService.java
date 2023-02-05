package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Group;
import com.example.demo.entity.Page;


public interface GroupService {
	List<Group> getAllGroups();
	
	Group saveGroup(Group group);
	
	Group getGroupById(Long id);
	
	Group updateGroup(Group group);
	
	void deleteGroupById(Long id);
	
	
}
