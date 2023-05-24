package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	//User loginUser(String emailId, String password, Long contactNo );
    User getUserId(Long userId);
    User getEmailId(String emailId);
   // void updateUser(User user);
    void deleteUser(Long userId);
	void updateUser(Long userId, String name, String emailId, String password);
	//User loginUser(String name, Long userId, String emailId, String password, Long contactNo);
	//User loginUser(Long userId, String name, String emailId, String password, Long contactNo);
	String check(String emailId, String password);

}
