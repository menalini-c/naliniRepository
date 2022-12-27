package com.snipe.hrms.service;

import java.util.List;

import com.snipe.hrms.domain.Employee;
import com.snipe.hrms.exception.HrmsException;

public interface EmployeeService {
	public List<Employee> getEmployeeRecords() throws HrmsException;
	public int addEmployeeRecord(Employee employee) throws HrmsException;
}
