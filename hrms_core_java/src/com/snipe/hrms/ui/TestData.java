package com.snipe.hrms.ui;

public class TestData {
	public static void main(String[] args) {
		String maxEmpNo = "SNP0001";
		String newMaxEmpNo = maxEmpNo.substring(3, maxEmpNo.length());
		System.out.println(newMaxEmpNo);
		long maxEmpNoLong = Long.parseLong(newMaxEmpNo);
		System.out.println(maxEmpNoLong);
	}
}
