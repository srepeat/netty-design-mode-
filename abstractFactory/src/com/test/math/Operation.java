package com.test.math;

//抽象bean
public abstract class Operation {

	private double num1;
	private double num2;
	
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	//抽象方法
	public abstract double getResule();
	
}
