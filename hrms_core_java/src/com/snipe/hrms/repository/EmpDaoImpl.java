package com.snipe.hrms.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.snipe.hrms.constants.IConstants;
import com.snipe.hrms.domain.Employee;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;

public class EmpDaoImpl {
	private String getMaxEmpNo() throws ClassNotFoundException, SQLException {
		String maxEmpNo = null;
		Connection connection = ConnectToDatabase.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(IConstants.SELECT_MAX_EMP_ID);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			if(rs.getString("emp_no") != null ) {
				maxEmpNo = rs.getString("emp_no");
			}
		}
		return maxEmpNo;
	}
	
	public int addEmployeeRecord(Employee employee) throws HrmsException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectToDatabase.getConnection();
			preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_EMP);
			
			String maxEmpNo = getMaxEmpNo();
			System.out.println(maxEmpNo);
			
			/*
			 * if(maxEmpNo != null) { String newMaxEmpNo = maxEmpNo.substring(3,
			 * maxEmpNo.length()); long maxEmpNoLong = Long.parseLong(newMaxEmpNo);
			 * maxEmpNoLong = maxEmpNoLong+1; maxEmpNo = IConstants.EMP_NO_STARTS_WITH +
			 * maxEmpNoLong; System.out.println(" New Emp No = "+maxEmpNo); }else { maxEmpNo
			 * = IConstants.EMP_NO_STARTS_WITH + Long.valueOf(1000l);
			 * System.out.println(" New Emp No = "+maxEmpNo); }
			 */
			preparedStatement.setString(1, maxEmpNo);
			preparedStatement.setString(2, employee.getDesignation());
			preparedStatement.setString(3, employee.getFirst_Name());
			preparedStatement.setString(4, employee.getSecond_Name());
			preparedStatement.setDate(5, Date.valueOf(employee.getDob()));
			preparedStatement.setDate(6, Date.valueOf(employee.getHire_Date()));
			preparedStatement.setString(7, employee.getGender());
			preparedStatement.setString(8, employee.getEmail_Id());
			preparedStatement.setLong(9, employee.getContact_No());
			preparedStatement.setString(10, employee.getPan_No());
			System.out.println(preparedStatement);
			
			int count = preparedStatement.executeUpdate();
			System.out.println(count);
			if(count > 0) {
				preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_EMP_ADD);
				preparedStatement.setString(1, maxEmpNo);
				preparedStatement.setString(2, employee.getEmp_Address().getHouse_no());
				preparedStatement.setString(3, employee.getEmp_Address().getStreet_no());
				preparedStatement.setString(4, employee.getEmp_Address().getLocality());
				preparedStatement.setLong(5, employee.getEmp_Address().getPin_code());
				preparedStatement.setString(6, employee.getEmp_Address().getCity());
				preparedStatement.setString(7, employee.getEmp_Address().getState());
				preparedStatement.setString(8, employee.getEmp_Address().getCountry());
				System.out.println(preparedStatement);
				count = preparedStatement.executeUpdate();
				System.out.println(count);
			}
			
		} catch (ClassNotFoundException cnfe) {
			throw new HrmsException(ErrorCode.LOAD_DRIVER_ERROR);
		}catch(SQLException se) {
			throw new HrmsException(ErrorCode.SQL_UNKNOWN_ERROR);
		}catch(Exception se) {
			throw new HrmsException(ErrorCode.UNKNOWN_ERROR);
		}
		return 0;
	}
}
