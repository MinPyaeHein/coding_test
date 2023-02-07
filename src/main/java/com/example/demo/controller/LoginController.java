package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class LoginController  {
	 
        @GetMapping("/login")
		String login() {
        	 System.out.println("Hello login");
			return "login";
		}
	}

