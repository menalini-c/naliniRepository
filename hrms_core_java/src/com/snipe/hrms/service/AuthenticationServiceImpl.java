package com.snipe.hrms.service;

import java.util.List;
import java.util.Map;

import com.snipe.hrms.domain.User;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.repository.AuthenticationDao;
import com.snipe.hrms.repository.AuthenticationDaoImpl;

public class AuthenticationServiceImpl implements AuthenticationService{
	
	AuthenticationDao authenticationDao = new AuthenticationDaoImpl();

	@Override
	public int addUserRecords(List<User> userList) throws HrmsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String,String> validateUserRecord(User user) throws HrmsException {
		return authenticationDao.validateUserRecord(user);
	}

	@Override
	public int deleteUserRecord(List<User> userList) throws HrmsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getUserRecords() throws HrmsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyUserRecord(List<User> userList) throws HrmsException {
		// TODO Auto-generated method stub
		return 0;
	}

}
