package com.snipe.hrms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.snipe.hrms.constants.IConstants;
import com.snipe.hrms.domain.User;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;

public class AuthenticationDaoImpl implements AuthenticationDao{

	@Override
	public int addUserRecords(List<User> userList) throws HrmsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String,String> validateUserRecord(User user) throws HrmsException {
		Connection connection = null;
		Map<String,String> userDetilsMap = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectToDatabase.getConnection();
			if(user.getUser_type().equals("ADMIN")) {
				preparedStatement = connection.prepareStatement(IConstants.SELECT_FROM_USER);
				preparedStatement.setString(1, user.getUser_name());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getUser_type());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					userDetilsMap = new HashMap<String,String>();
					userDetilsMap.put("user_id", rs.getString("user_id"));
					userDetilsMap.put("email_id", rs.getString("email_id"));
				}
			}else if(user.getUser_type().equals("EMPLOYEE")){
				preparedStatement = connection.prepareStatement(IConstants.SELECT_FROM_EMP);
				preparedStatement.setString(1, user.getUser_name());
				preparedStatement.setString(2, user.getPassword());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					userDetilsMap = new HashMap<String,String>();
					userDetilsMap.put("user_id", rs.getString("emp_no"));
					userDetilsMap.put("email_id", rs.getString("email_id"));
				}
			}
			System.out.println("no exception");
		}catch (ClassNotFoundException cnfe) {
			throw new HrmsException(ErrorCode.LOAD_DRIVER_ERROR);
		}catch(SQLException se) {
			throw new HrmsException(se.getMessage());
		}catch(Exception e) {
			throw new HrmsException(e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new HrmsException(e.getMessage());
			}
		}
		return userDetilsMap;
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
