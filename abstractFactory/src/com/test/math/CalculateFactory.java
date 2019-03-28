package com.test.math;
/**
 * 简单工厂方法
 * @author 鲜磊
 *
 */

public class CalculateFactory {

	public static Operation getOperation(String open) {
		if ("+".equals(open)) {
			return new addOperationFactory();
		}
		return null;
	}
}
