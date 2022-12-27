package com.snipe.hrms.controller;

import java.util.Scanner;


public class LoginController {
	Scanner scanner = new Scanner(System.in);
	
	public void getAdminPage() {
		System.out.println("========================= 1.MANAGE EMPLOYEE");
		System.out.println("========================= 2.MANAGE DEPARTMENT");
		System.out.println("========================= 3.MANAGE PAY GRADE");
		try {
			String option = scanner.next();
			switch(option) {
			case "1":{
				manageEmployee();
				break;
			}
			case "2":{
				manageDepartment();
				break;
			}
			case "3":{
				managePayGrade();
				break;
			}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}
	
	private void manageEmployee() {
		System.out.println("========================= 1.ADD NEW EMPLOYEE");
		System.out.println("========================= 2.UPDATE EMPLOYEE DETAILS");
		System.out.println("========================= 3.DELETE EMPLOYEE");
		System.out.println("========================= 4.VIEW ALL EMPLOYESS");
		EmployeeController employeeController = new EmployeeController();
		try {
			String option = scanner.next();
			switch(option) {
			case "1":{
				employeeController.addEmployeeRecord();
				break;
			}
			case "2":{
				System.out.println("Fuctionality need tobe implemented");
				break;
			}
			case "3":{
				System.out.println("Fuctionality need tobe implemented");
				break;
			}
			case "4":{
				employeeController.getEmployeeRecords();
				break;
			}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}
	private void managePayGrade() {
		System.out.println("========================= 1.ADD NEW PAY GRADE");
		System.out.println("========================= 2.LIST ALL PAY GRADES");
		System.out.println("========================= 3.GENERATE PAY SLIP");
		try {
			String option = scanner.next();
			PayGradeController payGradeController = new PayGradeController();
			switch(option) {
			case "1":{
				break;
			}
			case "2":{
				payGradeController.getPayGradeListOfMaps();
				break;
			}
			case "3":{
				break;
			}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}
	private void manageDepartment() {
		System.out.println("========================= 1.ADD NEW DEPARTMENT");
		System.out.println("========================= 2.UPDATE DEPARTMENT DETAILS");
		System.out.println("========================= 3.DELETE DEPARTMENT");
		System.out.println("========================= 4.LIST ALL DEPARTMENTS");
		try {
			String option = scanner.next();
			DepartmentController deptController = new DepartmentController();
			switch(option) {
			case "1":{
				deptController.addDepartmentrecord();
				break;
			}
			case "2":{
				System.out.println("Fuctionality need tobe implemented");
				break;
			}
			case "3":{
				System.out.println("Fuctionality need tobe implemented");
				break;
			}
			case "4":{
				deptController.getAllDepartments();
				break;
			}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}
	public void getEmployeePage() {
		System.out.println("========================= 1.VIEW MY PAY_SLIP");
		try {
			String option = scanner.next();
			switch(option) {
			case "1":{
				System.out.println("Functionality needs to be implemented");
				break;
			}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
		
	}
}
