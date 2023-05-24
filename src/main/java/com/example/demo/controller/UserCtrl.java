package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserCtrl {
	
	private final UserService userService;
    public UserCtrl(UserService userService) {
        this.userService = userService;
    }
    
    
    
    
    
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserDto userDto) {
        String emailId = userDto.getEmailId();
        String password = userDto.getPassword();
       
        String msg=userService.check(emailId,password);
        return msg;
    }
    
	
	
	
	@GetMapping("/{userId}")
    public ResponseEntity<User> getUserId(@PathVariable Long userId) {
        User user = userService.getUserId(userId);
        return ResponseEntity.ok(user);
    }
	
	
	@GetMapping("/emailId/{emailId}")
    public ResponseEntity<User> getEmailId(@PathVariable String emailId) {
        User user = userService.getEmailId(emailId);
        return ResponseEntity.ok(user);
    }
	
	
	
	@PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable Long userId, @RequestParam String name, @RequestParam String emailId, @RequestParam String password) {
        userService.updateUser(userId, name, emailId, password);
        return ResponseEntity.ok().build();
    }
	
	@DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
