package com.snipe.hrms.controller;

import java.util.Map;

import com.snipe.hrms.domain.User;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.service.AuthenticationService;
import com.snipe.hrms.service.AuthenticationServiceImpl;
import com.snipe.hrms.utility.VadilationUtility;

public class AuthenticationController {
	
	AuthenticationService authenticationService = null;
	
	public Map<String,String> authenticateUser(String username,String password,String role) throws HrmsException {
		//Scanner scanner = null;
		Map<String,String> userDetailRecord = null;
		
		try {
			if(!VadilationUtility.mobileNoValidatorPredicate.test(username))
				throw new HrmsException(ErrorCode.ENTER_VALID_USER_NAME);
			if(!VadilationUtility.passwordValidatorPredicate.test(password))
				throw new HrmsException(ErrorCode.ENTER_VALID_PASSWORD);
			
			authenticationService = new AuthenticationServiceImpl();
			User user = new User();
			user.setUser_name(username);
			user.setPassword(password);
			user.setUser_type(role);
			userDetailRecord = authenticationService.validateUserRecord(user);
			System.out.println(userDetailRecord);
			//user.setUser_type(password);
		}catch(Exception e) {
			throw new HrmsException(e.getMessage());
		}
		return userDetailRecord;
		
	}
}
