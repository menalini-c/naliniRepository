package com.snipe.hrms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.snipe.hrms.constants.IConstants;
import com.snipe.hrms.domain.Employee;
import com.snipe.hrms.domain.Employee_Address;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.password.PasswordGenerator;
import com.snipe.hrms.service.EmployeeService;
import com.snipe.hrms.service.EmployeeServiceImpl;
import com.snipe.hrms.utility.VadilationUtility;

public class EmployeeController {
	
	EmployeeService employeeService;
	
	public void getEmployeeRecords(){
		List<Employee>  employeeRecords = new  ArrayList<Employee>();
		try {
			employeeService = new EmployeeServiceImpl();
			employeeRecords = employeeService.getEmployeeRecords();
			if(employeeRecords != null && employeeRecords.size() >0)
				employeeRecords.stream().forEach(System.out::println);
			else
				throw new HrmsException("There are no Employess");
		}catch (HrmsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
		}
	}
	        
	public int addEmployeeRecord() throws HrmsException {
		Scanner scanner = null;
		int i = 0;
		StringBuilder empRecordStrBuilder = new  StringBuilder();
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter employee designation");
			String designation = scanner.next();
			
			if(designation == null || designation.length() <=  0) 
				throw new HrmsException(ErrorCode.EMPTY_INPUT);
			empRecordStrBuilder.append(designation+"$#$");
			
			System.out.println("Enter employee first Name");
			String firstName = scanner.next();
			if(firstName == null || firstName.length() <=  0) 
				throw new HrmsException(ErrorCode.EMPTY_INPUT);
			else if(!VadilationUtility.nameValidatorPredicate.test(firstName))
				throw new HrmsException(ErrorCode.EMP_NAME_VALIDATE_ERROR);
			empRecordStrBuilder.append(firstName+"$#$");
				
			System.out.println("Enter employee second Name");
			String secondName = scanner.next();
			if(secondName == null || secondName.length() <=  0) 
				throw new HrmsException(ErrorCode.EMPTY_INPUT);
			else if(!VadilationUtility.nameValidatorPredicate.test(secondName))
				throw new HrmsException(ErrorCode.EMP_NAME_VALIDATE_ERROR);
			empRecordStrBuilder.append(secondName+"$#$");
			
			System.out.println("Enter employee Date of Birth in YYYY-MM-DD format:");
			String dob = scanner.next();
			if(!VadilationUtility.dobValidatorPredicate.test(dob))
				throw new HrmsException(ErrorCode.DOB_VALIDATE_ERROR);
			empRecordStrBuilder.append(dob+"$#$");
			
			System.out.println("Enter employee gender");
			String gender = scanner.next();
			if(!VadilationUtility.genderValidatorPredicate.test(gender))
				throw new HrmsException(ErrorCode.GENDER_VALIDATE_ERROR);
			empRecordStrBuilder.append(gender+"$#$");
			
			System.out.println("Enter employee email Id");
			String emai_Id = scanner.next();
			if(!VadilationUtility.emailValidatorPredicate.test(emai_Id))
				throw new HrmsException(ErrorCode.EMAIL_VALIDATE_ERROR);
			empRecordStrBuilder.append(emai_Id+"$#$");
			
			System.out.println("Enter employee mobile No");
			String mobile_no = scanner.next();
			if(!VadilationUtility.mobileNoValidatorPredicate.test(mobile_no))
				throw new HrmsException(ErrorCode.MOBILE_NO_VALIDATE_ERROR);
			empRecordStrBuilder.append(mobile_no+"$#$");
			
			System.out.println("Enter employee pan_no");
			String pan_no = scanner.next();
			if(!VadilationUtility.panNoValidatorPredicate.test(pan_no))
				throw new HrmsException(ErrorCode.PAN_NO_VALIDATE_ERROR);
			empRecordStrBuilder.append(pan_no+"$#$");
			
			System.out.println("=========Enter employee Address details as follows==========");
			System.out.println("Enter House No/Door No ::");
			String hno = scanner.next();
			empRecordStrBuilder.append(hno+"$#$");
			
			System.out.println("Enter Street No/Road No ::");
			String streetNo = scanner.next();
			empRecordStrBuilder.append(streetNo+"$#$");
			
			System.out.println("Enter Colony ::");
			String colony = scanner.next();
			empRecordStrBuilder.append(colony+"$#$");
			
			System.out.println("Enter Area/Locality ::");
			String locality = scanner.next();
			empRecordStrBuilder.append(locality+"$#$");
			
			System.out.println("Enter pincode/zipcode ::");
			long pincode = scanner.nextLong();
			if(!VadilationUtility.pinCodeValidatorPredicate.test(String.valueOf(pincode)))
				throw new HrmsException(ErrorCode.PIN_CODE_VALIDATE_ERROR);
			empRecordStrBuilder.append(pincode+"$#$");
			
			System.out.println("Enter city ::");
			String city = scanner.next();
			if(!VadilationUtility.nameValidatorPredicate.test(city))
				throw new HrmsException(ErrorCode.NAME_VALIDATE_ERROR);
			empRecordStrBuilder.append(city+"$#$");
			
			System.out.println("Enter State ::");
			String state = scanner.next();
			if(!VadilationUtility.nameValidatorPredicate.test(state))
				throw new HrmsException(ErrorCode.NAME_VALIDATE_ERROR);
			empRecordStrBuilder.append(state+"$#$");
			
			System.out.println("Enter Country ::");
			String country = scanner.next();
			if(!VadilationUtility.nameValidatorPredicate.test(country))
				throw new HrmsException(ErrorCode.NAME_VALIDATE_ERROR);
			empRecordStrBuilder.append(country+"$#$");
			
			System.out.println("==================Enter Department Id where Employee is getting hired ===============");
			String depId = scanner.next();
			if(!VadilationUtility.numberValidatorPredicate.test(depId))
				throw new HrmsException(ErrorCode.NUMBER_VALIDATE_ERROR);
			empRecordStrBuilder.append(String.valueOf(depId)+"$#$");
			
			System.out.println("==================Enter Grade Id into which Employee is getting hired ===============");
			String gradeId = scanner.next();
			if(!VadilationUtility.numberValidatorPredicate.test(gradeId))
				throw new HrmsException(ErrorCode.NUMBER_VALIDATE_ERROR);
			empRecordStrBuilder.append(String.valueOf(gradeId)+"$#$");
			
			System.out.println("==================Enter Manager Id for the Employee If exists(Y/N) ===============");
			String isManagerAvail = scanner.next();
			String managerId = null;
			if(isManagerAvail.equals("Y") || isManagerAvail.equals("N")) {
				if(isManagerAvail.equals("Y")) {
					System.out.println("==================Enter Manager Id for the Employee ===============");
					managerId = scanner.next();
					if(!VadilationUtility.numberValidatorPredicate.test(managerId))
						throw new HrmsException(ErrorCode.NUMBER_VALIDATE_ERROR);
					empRecordStrBuilder.append(String.valueOf(managerId)+"$#$");
				}
				
				System.out.println("empRecordStrBuilder ::"+empRecordStrBuilder);
				
				Employee employee = new Employee();
				employee.setDesignation(designation);
				employee.setFirst_Name(firstName);
				employee.setSecond_Name(secondName);
				LocalDate localDateDob = LocalDate.parse(dob);
				employee.setDob(localDateDob);
				if(gender.equals(IConstants.GENDER_F))
					employee.setGender(IConstants.GENDER_F);
				else if(gender.equals(IConstants.GENDER_M))
					employee.setGender(IConstants.GENDER_M);
				LocalDate hireDate = LocalDate.now();
				employee.setHire_Date(hireDate);
				employee.setEmail_Id(emai_Id);
				employee.setContact_No(Long.valueOf(mobile_no));
				employee.setPan_No(pan_no);
				Employee_Address employee_Address = new Employee_Address();
				employee_Address.setHouse_no(hno);
				employee_Address.setStreet_no(streetNo);
				employee_Address.setColony(colony);
				employee_Address.setLocality(locality);
				employee_Address.setPin_code(pincode);
				employee_Address.setCity(city);
				employee_Address.setState(state);
				employee_Address.setCountry(country);
				employee.setDept_No(depId);
				employee.setJob_Id(gradeId);
				employee.setManager_No(managerId);
				employee.setEmp_Address(employee_Address);
				
				String password = PasswordGenerator.generateStrongPassword();
				employee.setPassword(password);
				employeeService = new EmployeeServiceImpl();
				i = employeeService.addEmployeeRecord(employee);
				System.out.println(i);
			}else {
				throw new HrmsException(ErrorCode.ENTER_Y_N);
			}
			
			
		} catch (Exception e) {
			throw new HrmsException(e.getMessage());
		}finally {
			scanner.close();
		}
		return i;
	}
}
