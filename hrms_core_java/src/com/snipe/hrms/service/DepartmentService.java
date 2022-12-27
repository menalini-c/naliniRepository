package com.snipe.hrms.service;

import java.util.List;

import com.snipe.hrms.domain.Department;
import com.snipe.hrms.exception.HrmsException;

public interface DepartmentService {
	public int addDepartmentrecord(Department dept) throws HrmsException;
	public List<Department> getAllDepartments() throws HrmsException;
}
