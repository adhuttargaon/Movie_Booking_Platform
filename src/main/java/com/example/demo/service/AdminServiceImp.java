package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public Admin createAdmin(Admin admin) {
	
		return adminRepo.save(admin);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepo.existsByEmail(email);
	}

}
