package com.test.math;

/**
 * ���󷽷�ģʽ
 * @author ����
 *
 */
public class addOperationFactory extends Operation {

	@Override
	public double getResule() {
		double result = this.getNum1() + this.getNum2();
		return result;
	}

}
