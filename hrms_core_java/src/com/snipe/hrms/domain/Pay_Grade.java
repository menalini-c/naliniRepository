package com.snipe.hrms.domain;

public class Pay_Grade {
	
	private String pay_grade_id;
	private String grade_name;
	private double grade_basic;
	private double grade_ta;
	private double grade_da;
	private double grade_hra;
	private double grade_ma;
	private double grade_bonus;
	private double grade_pf;
	private double grade_pt;
	
	public String getPay_grade_id() {
		return pay_grade_id;
	}
	public void setPay_grade_id(String pay_grade_id) {
		this.pay_grade_id = pay_grade_id;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public double getGrade_basic() {
		return grade_basic;
	}
	public void setGrade_basic(double grade_basic) {
		this.grade_basic = grade_basic;
	}
	public double getGrade_ta() {
		return grade_ta;
	}
	public void setGrade_ta(double grade_ta) {
		this.grade_ta = grade_ta;
	}
	public double getGrade_da() {
		return grade_da;
	}
	public void setGrade_da(double grade_da) {
		this.grade_da = grade_da;
	}
	public double getGrade_hra() {
		return grade_hra;
	}
	public void setGrade_hra(double grade_hra) {
		this.grade_hra = grade_hra;
	}
	public double getGrade_ma() {
		return grade_ma;
	}
	public void setGrade_ma(double grade_ma) {
		this.grade_ma = grade_ma;
	}
	public double getGrade_bonus() {
		return grade_bonus;
	}
	public void setGrade_bonus(double grade_bonus) {
		this.grade_bonus = grade_bonus;
	}
	public double getGrade_pf() {
		return grade_pf;
	}
	public void setGrade_pf(double grade_pf) {
		this.grade_pf = grade_pf;
	}
	public double getGrade_pt() {
		return grade_pt;
	}
	public void setGrade_pt(double grade_pt) {
		this.grade_pt = grade_pt;
	}
	@Override
	public String toString() {
		return "Pay_Grade [pay_grade_id=" + pay_grade_id + ", grade_name=" + grade_name + ", grade_basic=" + grade_basic
				+ ", grade_ta=" + grade_ta + ", grade_da=" + grade_da + ", grade_hra=" + grade_hra + ", grade_ma="
				+ grade_ma + ", grade_bonus=" + grade_bonus + ", grade_pf=" + grade_pf + ", grade_pt=" + grade_pt + "]";
	}
	
}
