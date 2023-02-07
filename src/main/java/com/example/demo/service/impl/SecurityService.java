package com.example.demo.service.impl;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

  @Secured("USER")
  public String secure() {
    return "Hello Security";
  }
}