package com.test.math;
/**
 * �򵥹�������
 * @author ����
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
