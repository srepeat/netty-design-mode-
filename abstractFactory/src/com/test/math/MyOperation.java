package com.test.math;

/**
 * 工厂方法模式
 * @author 鲜磊
 *
 */
public class MyOperation implements OperationFactoryInfac{

	@Override
	public Operation getOperation() {
		// TODO Auto-generated method stub
		return new addOperationFactory();
	}

}
