package com.test.math;

/**
 * ��������ģʽ
 * @author ����
 *
 */
public class MyOperation implements OperationFactoryInfac{

	@Override
	public Operation getOperation() {
		// TODO Auto-generated method stub
		return new addOperationFactory();
	}

}
