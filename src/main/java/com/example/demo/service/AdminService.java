package com.example.demo.service;

import com.example.demo.entity.Admin;

public interface AdminService {
	public Admin createAdmin(Admin admin);
	public boolean checkEmail(String email);

}
