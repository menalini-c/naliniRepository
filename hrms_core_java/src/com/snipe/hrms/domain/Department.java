package com.snipe.hrms.domain;

public class Department {
	
	private String dept_No;
	private String dept_name;
	private String location;
	
	public String getDept_No() {
		return dept_No;
	}
	public void setDept_No(String dept_No) {
		this.dept_No = dept_No;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Department [dept_No=" + dept_No + ", dept_name=" + dept_name + ", location=" + location + "]";
	}
	
}
