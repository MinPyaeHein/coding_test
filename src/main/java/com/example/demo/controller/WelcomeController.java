package com.example.demo.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.StaffService;

@Controller
public class WelcomeController {
	@Autowired
	StaffService staffService;

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String welcomePage(ModelMap model) {
		/*  UserDetails details = staffService.loadUserByUsername("nini123@gmail.com");
	      if (details != null ) {
	    	for(GrantedAuthority gg: details.getAuthorities()) {
	    		System.out.println(gg.getAuthority());
	    	}
		       
	    	  System.out.println("Hello ...NiNi.");
	      }*/
		 
	        return "welcome";
	  }}
	
