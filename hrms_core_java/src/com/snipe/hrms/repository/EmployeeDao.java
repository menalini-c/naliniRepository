package com.snipe.hrms.repository;

import java.util.List;

import com.snipe.hrms.domain.Employee;
import com.snipe.hrms.exception.HrmsException;

public interface EmployeeDao {
	public List<Employee> getEmployeeRecords() throws HrmsException;
	public int addEmployeeRecord(Employee employee) throws HrmsException;
	public int updateEmployeeRecord(Employee employee) throws HrmsException;
	public int deleteEmployeeRecord(Employee employee) throws HrmsException;
}
