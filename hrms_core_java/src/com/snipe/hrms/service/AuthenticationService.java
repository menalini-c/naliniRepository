package com.snipe.hrms.service;

import java.util.List;
import java.util.Map;

import com.snipe.hrms.domain.User;
import com.snipe.hrms.exception.HrmsException;

public interface AuthenticationService {
	public int addUserRecords(List<User> userList) throws HrmsException;
	public Map<String,String> validateUserRecord(User user) throws HrmsException;
	public int deleteUserRecord(List<User> userList) throws HrmsException;
	public List<User> getUserRecords() throws HrmsException;
	public int modifyUserRecord(List<User> userList) throws  HrmsException;
}
