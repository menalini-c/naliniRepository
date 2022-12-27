package com.snipe.hrms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.snipe.hrms.domain.Pay_Grade;
import com.snipe.hrms.exception.HrmsException;
import com.snipe.hrms.service.PayGradeService;
import com.snipe.hrms.service.PayGradeServiceImpl;

public class PayGradeController{
	
	PayGradeService payGradeService = new PayGradeServiceImpl();
	
	public void addNewPayGradeRecord(Pay_Grade payGrade) {
		
		Scanner scanner = new Scanner(System.in);
		try {
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
		
	}
	
	public void getPayGradeListOfMaps() {
		List<Map<String,String>>  payGradeListOfMaps = new  ArrayList<Map<String,String>>();
		try {
			payGradeListOfMaps = payGradeService.getPayGradeListOfMaps();
			payGradeListOfMaps.forEach(map -> map.forEach((k,v) -> System.out.println(k+" :: "+v)));
		} catch (HrmsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}