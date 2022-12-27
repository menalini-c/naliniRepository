package com.snipe.hrms.service;

import java.util.List;
import java.util.Map;

import com.snipe.hrms.domain.Pay_Grade;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.repository.PayGradeDao;
import com.snipe.hrms.repository.PayGradeDaoImpl;

public class PayGradeServiceImpl implements  PayGradeService{
	
	PayGradeDao payGradeDao = new PayGradeDaoImpl();

	@Override
	public int addNewPayGrade(Pay_Grade pay_grade) throws HrmsException {
		return payGradeDao.addNewPayGrade(pay_grade);
	}

	@Override
	public List<Map<String, String>> getPayGradeListOfMaps() throws HrmsException {
		return payGradeDao.getPayGradeListOfMaps();
	}

}
