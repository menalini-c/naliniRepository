package com.snipe.hrms.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.snipe.hrms.constants.IConstants;
import com.snipe.hrms.domain.Employee;
import com.snipe.hrms.domain.Employee_Address;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;

public class EmployeeDaoImpl implements EmployeeDao{
	
	@Override
	public List<Employee> getEmployeeRecords() throws HrmsException {
		Connection connection = null;
		List<Employee> employeesList = new ArrayList<Employee>();
		try {
			connection = ConnectToDatabase.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IConstants.SELECT_EMPLOYEES_LIST_QUERY);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmp_No(rs.getString("emp_no"));
				employee.setDesignation(rs.getString("emp_desig"));
				employee.setFirst_Name(rs.getString("first_name"));
				employee.setSecond_Name(rs.getString("last_name"));
				employee.setDob(rs.getDate("dob").toLocalDate());
				employee.setHire_Date(rs.getDate("hire_date").toLocalDate());
				employee.setGender(rs.getString("gender"));
				employee.setEmail_Id(rs.getString("email_id"));
				employee.setContact_No(rs.getLong("mobile_no"));
				employee.setPan_No(rs.getString("pan_no"));
				employee.setUser_name(rs.getString("mobile_no"));
				employee.setPassword(rs.getString("password"));
				employee.setDept_No(String.valueOf(rs.getInt("emp_dept_no")));
				employee.setJob_Id(String.valueOf(rs.getInt("emp_grade_id")));
				employee.setManager_No(String.valueOf(rs.getInt("emp_manager_no")));
				
				Employee_Address employeeAddress = new Employee_Address();
				employeeAddress.setHouse_no(rs.getString("h_no"));
				employeeAddress.setStreet_no(rs.getString("street_no"));
				employeeAddress.setColony(rs.getString("colony"));
				employeeAddress.setLocality(rs.getString("locality"));
				employeeAddress.setPin_code(rs.getLong("pincode"));
				employeeAddress.setCity(rs.getString("city"));
				employeeAddress.setState(rs.getString("state"));
				employeeAddress.setCountry(rs.getString("country"));
				employee.setEmp_Address(employeeAddress);
				employeesList.add(employee);
			}
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
		return employeesList;
	}

	
	
	
	public int addEmployeeRecord(Employee employee) throws HrmsException{
		Connection connection = null;
		int record = 0;
		try {
			connection = ConnectToDatabase.getConnection();
			int deptId = 0;
			PreparedStatement preparedStatement = connection.prepareStatement(IConstants.SELECT_FROM_DEPT_USING_DEPT_ID);
			preparedStatement.setString(1, employee.getDept_No());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				deptId = rs.getInt(1);
			}
			if(deptId > 0) {
				int gradeId = 0;
				preparedStatement = connection.prepareStatement(IConstants.SELECT_FROM_GRADE_USING_GRADE_ID);
				preparedStatement.setString(1, employee.getJob_Id());
				rs = preparedStatement.executeQuery();
				while(rs.next()) {
					gradeId = rs.getInt(1);
				}
				if(gradeId > 0) {
					int generatedEmpId = insertRecordIntoEmp(employee,connection);
					if(generatedEmpId >0) {
						record  = insertRecordIntoEmpAddress(employee,connection,generatedEmpId);
						if(record > 0) {
							preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_EMP_GRADE_DETAIL);
							preparedStatement.setInt(1, generatedEmpId);
							preparedStatement.setString(2, employee.getDept_No());
							preparedStatement.setString(3, employee.getJob_Id());
							preparedStatement.setDate(4, Date.valueOf(employee.getHire_Date()));
							preparedStatement.setString(5, employee.getManager_No());
							System.out.println(preparedStatement);
							record = preparedStatement.executeUpdate();
							if(record > 0) {
								System.out.println("Employee added successfully....!!!!");
								System.out.println("Use Mobile No as Username for LOGIN ::: ");
								System.out.println("Password Generated :: "+employee.getPassword());
							}
								
						}
					}
				}else {
					throw new HrmsException(ErrorCode.GRADE_DOESNT_EXIST);
				}
			}else {
				throw new HrmsException(ErrorCode.DEPT_DOESNT_EXIST);
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
		return record;
	}
	
	private int insertRecordIntoEmpAddress(Employee employee,Connection connection,int generatedEmpId) throws SQLException{
		int recordInserted = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_EMP_ADD);
		preparedStatement.setInt(1, generatedEmpId);
		preparedStatement.setString(2, employee.getEmp_Address().getHouse_no());
		preparedStatement.setString(3, employee.getEmp_Address().getStreet_no());
		preparedStatement.setString(4, employee.getEmp_Address().getColony());
		preparedStatement.setString(5, employee.getEmp_Address().getLocality());
		preparedStatement.setLong(6, employee.getEmp_Address().getPin_code());
		preparedStatement.setString(7, employee.getEmp_Address().getCity());
		preparedStatement.setString(8, employee.getEmp_Address().getState());
		preparedStatement.setString(9, employee.getEmp_Address().getCountry());
		System.out.println(preparedStatement);
		recordInserted = preparedStatement.executeUpdate();
		return recordInserted;
	}
	private int insertRecordIntoEmp(Employee employee,Connection connection) throws SQLException {
		int generatedEmpId = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_EMP_WITH_OUT_EMP_NO, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, employee.getDesignation());
		preparedStatement.setString(2, employee.getFirst_Name());
		preparedStatement.setString(3, employee.getSecond_Name());
		preparedStatement.setDate(4, Date.valueOf(employee.getDob()));
		preparedStatement.setDate(5, Date.valueOf(employee.getHire_Date()));
		preparedStatement.setString(6, employee.getGender());
		preparedStatement.setString(7, employee.getEmail_Id());
		preparedStatement.setLong(8, employee.getContact_No());
		preparedStatement.setString(9, employee.getPan_No());
		preparedStatement.setString(10, employee.getPassword());
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		
		while (rs.next()) {
			generatedEmpId = rs.getInt(1);
		}
		preparedStatement.close();
		return generatedEmpId;
	}




	@Override
	public int updateEmployeeRecord(Employee employee) throws HrmsException {
		
		return 0;
	}




	@Override
	public int deleteEmployeeRecord(Employee employee) throws HrmsException {
		return 0;
	}

}
