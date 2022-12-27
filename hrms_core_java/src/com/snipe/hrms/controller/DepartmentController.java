package com.snipe.hrms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.snipe.hrms.domain.Department;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.service.DepartmentService;
import com.snipe.hrms.service.DepartmentServiceImpl;

public class DepartmentController {
	
	DepartmentService deptService = null;
	
	public void addDepartmentrecord() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Department Name::");
			String deptName = scanner.next();
			
			System.out.println("Enter Department location ::");
			String deptLocation = scanner.next();
			
			Department department = new Department();
			department.setDept_name(deptName);
			department.setLocation(deptLocation);
			
			deptService = new DepartmentServiceImpl();
			deptService.addDepartmentrecord(department);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}

	public void getAllDepartments() {
		List<Department>  deptList = new  ArrayList<Department>();
		try {
			deptService = new DepartmentServiceImpl();
			deptList = deptService.getAllDepartments();
			//System.out.println(deptList);
			if(deptList != null && deptList.size() >0) {
				for(Department dept : deptList) {
					System.out.println("Department name :"+dept.getDept_name());
					System.out.println("Department No :"+dept.getDept_No());
					System.out.println("Department name :"+dept.getLocation());
				}
			}else {
				throw new HrmsException("There are no departments");
			}
			
		} catch (HrmsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
