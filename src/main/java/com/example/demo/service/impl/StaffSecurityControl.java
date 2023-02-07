package com.example.demo.service.impl;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Page;

@Component
public class StaffSecurityControl {
    @Autowired
    private PageServiceImpl serviceImpl;

    public boolean checkUserId(Authentication authentication, Long id) {
        String name = authentication.name();
        System.out.println(name+" at "+id);
        List<Page> pages= serviceImpl.getPagetByStaffId(id);
        System.out.println("pages="+pages.size());
        return pages != null;
    }
}