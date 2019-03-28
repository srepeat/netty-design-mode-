package com.test.math;

/**
 * 抽象方法模式
 * @author 鲜磊
 *
 */
public class addOperationFactory extends Operation {

	@Override
	public double getResule() {
		double result = this.getNum1() + this.getNum2();
		return result;
	}

}
