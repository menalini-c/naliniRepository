package com.snipe.hrms.service;

import java.util.List;
import java.util.Map;

import com.snipe.hrms.domain.Pay_Grade;
import com.snipe.hrms.exception.HrmsException;

public interface PayGradeService {
	public int addNewPayGrade(Pay_Grade pay_grade) throws HrmsException;
	public List<Map<String,String>> getPayGradeListOfMaps() throws HrmsException;
}
