package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.Student;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.UserServic;
import com.example.demo.service.EmailSenderService;
import com.example.demo.service.StudentService;


@Service
public class UserServiceImpl implements UserServic{
	@Autowired
    private EmailSenderService  emailSenderService;
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository
			                 ) {
		super();
		this.userRepository = userRepository;

		
	}

	@Override
	public List<User> getAllCustomers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User customer) {
		return userRepository.save(customer);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User customer) {
		return userRepository.save(customer);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);	
	}
    
	@Override
	public int getAllUsersCount() {
		System.out.println("getAllUsersCount");
		return userRepository.findAllCustomersCount();
	}
	
	//@Scheduled(fixedRate = 5000)
	public void getAllUsersCountScheduled() {
		List<User> users=userRepository.findAllUsersByMailStatus(false);
		System.out.println("ScheduledGetAllUsersCount="+users.size());
		for(User u : users) {
			emailSenderService.sendSimpleEmail(u.getEmail(),"User Manaement System","Thank For your registration!");
			u.setMailStatus(true);
			updateUser(u);
		}
		
		
	}
/*	@Override
	public void savePurchesHistoryAndCustomer(Customer customer,PurchaseHistory purchaseHistory){
		Customer customerNew=customerRepository.save(customer);
		PaymentMethod paymentMethod=paymentMethodRepository.findByName("VISA");
		System.out.println("paymentMethod="+paymentMethod.getName());
		Evoucher evoucher=evoucherRepository.findById((long)1).get();
		purchaseHistory.setPaymentMethod(paymentMethod);
		purchaseHistory.setEvoucher(evoucher);
		purchaseHistory.setCustomer(customerNew);
		purchaseHistory=purchaseHistoryRepository.save(purchaseHistory);
		System.out.println("Name="+ purchaseHistory.getCustomer().getName()); 
		
	}*/

	@Override
	public List<User> getAllUsersByStatus() {
		return userRepository.findAllUsersByMailStatus(true);
	}

}
