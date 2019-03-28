package com.test.math;

import java.util.Scanner;

/**
 * 主类进行测试
 * @author 鲜磊
 * 计算器
 *
 */
public class MainTestMath {

	public static void main(String[] args) {
		//控制台输入
		Scanner input = new Scanner(System.in);
		System.out.println("---计算器---");
		System.out.println("请输入..");
		System.out.println("输入操作的第一个数字:");
		String strNum1 = input.nextLine();
		System.out.println("输入运算符:");
		String oper = input.nextLine();
		System.out.println("输入操作的第二个数字:");
		String strNum2 = input.nextLine();
		
		//设置一个初始结果变量
		double result = 0;
		//进行数字类型转换
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		//运算结果
		//传统方法模式
		
		//简单工厂模式
//		Operation operation = CalculateFactory.getOperation(oper);
//		operation.setNum1(num1);
//		operation.setNum2(num2);
//		result = operation.getResule();
		
		//抽象方法工厂
//		Operation operation = new addOperationFactory();
//		operation.setNum1(num1);
//		operation.setNum2(num2);
//		result = operation.getResule();
		//方法工厂
		if("+".equals(oper)) {
			OperationFactoryInfac factoryInfac = new MyOperation();
			Operation operation = factoryInfac.getOperation();
			operation.setNum1(num1);
			operation.setNum2(num2);
			result = operation.getResule();
		}
		//返回结果集
		System.out.println(num1 + oper + num2 +" = "+ result);
		
	}
}
