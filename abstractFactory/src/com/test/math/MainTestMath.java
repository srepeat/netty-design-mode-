package com.test.math;

import java.util.Scanner;

/**
 * ������в���
 * @author ����
 * ������
 *
 */
public class MainTestMath {

	public static void main(String[] args) {
		//����̨����
		Scanner input = new Scanner(System.in);
		System.out.println("---������---");
		System.out.println("������..");
		System.out.println("��������ĵ�һ������:");
		String strNum1 = input.nextLine();
		System.out.println("���������:");
		String oper = input.nextLine();
		System.out.println("��������ĵڶ�������:");
		String strNum2 = input.nextLine();
		
		//����һ����ʼ�������
		double result = 0;
		//������������ת��
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		//������
		//��ͳ����ģʽ
		
		//�򵥹���ģʽ
//		Operation operation = CalculateFactory.getOperation(oper);
//		operation.setNum1(num1);
//		operation.setNum2(num2);
//		result = operation.getResule();
		
		//���󷽷�����
//		Operation operation = new addOperationFactory();
//		operation.setNum1(num1);
//		operation.setNum2(num2);
//		result = operation.getResule();
		//��������
		if("+".equals(oper)) {
			OperationFactoryInfac factoryInfac = new MyOperation();
			Operation operation = factoryInfac.getOperation();
			operation.setNum1(num1);
			operation.setNum2(num2);
			result = operation.getResule();
		}
		//���ؽ����
		System.out.println(num1 + oper + num2 +" = "+ result);
		
	}
}
