package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;

public interface UserServic {
	List<User> getAllCustomers();
	
	User saveUser(User customer);
	
	User getUserById(Long id);
	
	User updateUser(User customer);
	
	void deleteUserById(Long id);
	
	int getAllUsersCount();
	
	List<User> getAllUsersByStatus();

}
