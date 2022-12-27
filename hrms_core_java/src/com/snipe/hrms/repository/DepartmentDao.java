package com.snipe.hrms.repository;

import java.util.List;

import com.snipe.hrms.domain.Department;
import com.snipe.hrms.exception.HrmsException;

public interface DepartmentDao {
	
	public int addDepartmentrecord(Department dept) throws HrmsException;
	public List<Department> getAllDepartments() throws HrmsException;
	
}
