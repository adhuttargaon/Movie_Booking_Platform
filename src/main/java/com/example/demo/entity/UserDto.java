package com.example.demo.entity;

public class UserDto {
	
	private String emailId;
	private String password;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [emailId=" + emailId + ", password=" + password + "]";
	}
	
	

}
