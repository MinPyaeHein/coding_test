package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String welcomePage(ModelMap model) {
		  System.out.println("Hello login");
	        return "welcome";
	  }
	  @RequestMapping(value = "/successLogin", method = RequestMethod.GET)
	  public String successLoginPage(ModelMap model) {
	        System.out.println("Success Hello login");
	        return "welcome";
	  }
}
