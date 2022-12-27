package com.snipe.hrms.ui;

import java.util.Map;
import java.util.Scanner;

import com.snipe.hrms.controller.AuthenticationController;
import com.snipe.hrms.controller.LoginController;

public class TestMockHrmsApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------------WELCOME TO HRMS-----------------------------");
		System.out.println("------------------------------Please Select Ur Role From The Below Options To Login--------------------");
		System.out.println("====================  1. Admin");
		System.out.println("====================  2. Employee");
		
		try {
			String role = scanner.next();
			if(role.equalsIgnoreCase("Admin") || role.equals("1"))
				role =  "ADMIN";
			else if(role.equalsIgnoreCase("Employee") ||  role.equals("2"))
				role = "EMPLOYEE";
			
			if(role.equals("ADMIN") || role.equals("EMPLOYEE")) {
				System.out.println("Hello ......!!!!  ");
				System.out.println("================== Please Enter Login details for Authentication =================");
				System.out.println("Enter username ::");
				String username = scanner.next();
				System.out.println("Enter password ::");
				String password = scanner.next();
				
				if(username !=  null && username.length() > 0 && password !=  null && password.length() >0) {
					AuthenticationController authenticationController = new AuthenticationController();
					Map<String,String> userRecordMap  = authenticationController.authenticateUser(username,password,role);
					if(userRecordMap != null && userRecordMap.containsKey("user_id") && userRecordMap.containsKey("email_id")) {
						System.out.println("WELCOME .........!!!!  "+ userRecordMap.get("user_id") +"========"+ role);
						LoginController loginController = new LoginController();
						switch(role) {
							case "ADMIN" : {
								loginController.getAdminPage();
								break;
							}
							case "EMPLOYEE" : {
								loginController.getEmployeePage();
								break;
							}
						}
					}else {
						System.out.println("=========== PLEASE ENTER VALID USERNAME AND PASSWORD 1 ================");
					}
					
				}else {
					System.out.println("=========== PLEASE ENTER VALID USERNAME AND PASSWORD 2 ================");
				}
				
			}else {
				System.out.println("=========== PLEASE SELECT ONLY FROM THE OPTIONS PROVIDED ================");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
