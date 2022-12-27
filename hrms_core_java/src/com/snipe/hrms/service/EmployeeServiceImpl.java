package com.snipe.hrms.service;

import java.util.List;

import com.snipe.hrms.domain.Employee;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.repository.EmployeeDao;
import com.snipe.hrms.repository.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public int addEmployeeRecord(Employee employee) throws HrmsException {
		return employeeDao.addEmployeeRecord(employee);
	}

	@Override
	public List<Employee> getEmployeeRecords() throws HrmsException {
		return employeeDao.getEmployeeRecords();
	}

}
