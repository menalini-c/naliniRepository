package com.snipe.hrms.service;

import java.util.List;

import com.snipe.hrms.domain.Department;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.repository.DepartmentDao;
import com.snipe.hrms.repository.DepartmentDaoImpl;

public class DepartmentServiceImpl implements DepartmentService{
	
	DepartmentDao deptDao = new DepartmentDaoImpl();
	
	@Override
	public int addDepartmentrecord(Department dept) throws HrmsException {
		return deptDao.addDepartmentrecord(dept);
	}

	@Override
	public List<Department> getAllDepartments() throws HrmsException {
		return deptDao.getAllDepartments();
	}

}
