package com.snipe.hrms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snipe.hrms.constants.IConstants;
import com.snipe.hrms.domain.Department;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public int addDepartmentrecord(Department dept) throws HrmsException {
		
		Connection connection = null;
		int record = 0;
		try {
			connection = ConnectToDatabase.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_DEPT);
			preparedStatement.setString(1, dept.getDept_name());
			preparedStatement.setString(2, dept.getLocation());
			record = preparedStatement.executeUpdate();
			if(record > 0)
				System.out.println("Department added successfully....!!!!");
		}catch (ClassNotFoundException cnfe) {
			throw new HrmsException(ErrorCode.LOAD_DRIVER_ERROR);
		}catch(SQLException se) {
			throw new HrmsException(se.getMessage());
		}catch(Exception se) {
			throw new HrmsException(se.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new HrmsException(e.getMessage());
			}
		}
		
		return record;
	}

	@Override
	public List<Department> getAllDepartments() throws HrmsException {
		Connection connection = null;
		List<Department> deptList = new ArrayList<Department>();
		try {
			connection = ConnectToDatabase.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IConstants.SELECT_FROM_DEPT);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setDept_No(rs.getString("dept_no"));
				dept.setDept_name(rs.getString("dept_name"));
				dept.setLocation(rs.getString("dept_location"));
				deptList.add(dept);
			}
		}catch (ClassNotFoundException cnfe) {
			throw new HrmsException(ErrorCode.LOAD_DRIVER_ERROR);
		}catch(SQLException se) {
			throw new HrmsException(se.getMessage());
		}catch(Exception se) {
			throw new HrmsException(se.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new HrmsException(e.getMessage());
			}
		}
		return deptList;
	}

}
