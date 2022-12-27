package com.snipe.hrms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.snipe.hrms.constants.IConstants;
import com.snipe.hrms.domain.Department;
import com.snipe.hrms.domain.Pay_Grade;
import com.snipe.hrms.exception.ErrorCode;
import com.snipe.hrms.exception.HrmsException;

public class PayGradeDaoImpl implements PayGradeDao{

	@Override
	public int addNewPayGrade(Pay_Grade pay_grade) throws HrmsException {
		Connection connection = null;
		int record = 0;
		try {
			connection = ConnectToDatabase.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IConstants.INSERT_INTO_PAY_GRADE);
			preparedStatement.setString(1, pay_grade.getGrade_name());
			preparedStatement.setDouble(2, pay_grade.getGrade_basic());
			preparedStatement.setDouble(3, pay_grade.getGrade_ta());
			preparedStatement.setDouble(4, pay_grade.getGrade_da());
			preparedStatement.setDouble(5, pay_grade.getGrade_hra());
			preparedStatement.setDouble(6, pay_grade.getGrade_ma());
			preparedStatement.setDouble(7, pay_grade.getGrade_bonus());
			preparedStatement.setDouble(8, pay_grade.getGrade_pf());
			preparedStatement.setDouble(9, pay_grade.getGrade_pt());
			record = preparedStatement.executeUpdate();
			if(record > 0)
				System.out.println("New Pay_Grade Inserted Successfully");
			
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
	public List<Map<String, String>> getPayGradeListOfMaps() throws HrmsException {
		List<Map<String, String>> payGradeListOfMaps = new ArrayList<Map<String,String>>();
		Connection connection = null;
		try {
			connection = ConnectToDatabase.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IConstants.SELECT_FROM_GRADE);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				HashMap<String, String> map = new HashMap<String,String>();
				map.put("grade_id", rs.getString("grade_id"));
				map.put("grade_name", rs.getString("grade_name"));
				map.put("grade_basic", String.valueOf(rs.getDouble("grade_basic")));
				map.put("grade_ta", String.valueOf(rs.getDouble("grade_ta")));
				map.put("grade_da", String.valueOf(rs.getDouble("grade_da")));
				map.put("grade_hra", String.valueOf(rs.getDouble("grade_hra")));
				map.put("grade_ma", String.valueOf(rs.getDouble("grade_ma")));
				map.put("grade_bonus", String.valueOf(rs.getDouble("grade_bonus")));
				map.put("grade_pf", String.valueOf(rs.getDouble("grade_pf")));
				map.put("grade_pt", String.valueOf(rs.getDouble("grade_pt")));
				payGradeListOfMaps.add(map);
				System.out.println("payGradeListOfMaps ::"+payGradeListOfMaps);
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
		return payGradeListOfMaps;
	}

}
