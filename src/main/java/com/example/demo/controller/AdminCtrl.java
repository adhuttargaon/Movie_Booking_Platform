package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
@Controller
public class AdminCtrl {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/RegisterPage")
	public String register() {
		return"RegisterPage";
	}

	@GetMapping("/AdminLogin")
	public String login() {
		return"AdminLogin";
	}
	
	@PostMapping("/createAdmin")
	public String createAdmin(@ModelAttribute Admin admin, HttpSession session ) {
		
		boolean f=adminService.checkEmail(admin.getEmail());
		if(f) {
    		session.setAttribute("message", "Email Id Already Exists");
    	}else {
    		Admin admin1 = adminService.createAdmin(admin);
        	if(admin1!=null) {
        		session.setAttribute("message", "Register Sucessfully");
        	}else {
        		session.setAttribute("message", "Something wrong on server");
        	}
    	}
    	return "redirect:/RegisterPage";
    }
	@GetMapping("/adminHomePage")
	public String AdminHomePage() {
		return"adminHomePage";
	}
}
