package com.snipe.hrms.domain;

public class User {
	
	private String user_name;
	private String password;
	private String user_type;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", password=" + password + ", user_type=" + user_type + "]";
	}
	
	
	
}
