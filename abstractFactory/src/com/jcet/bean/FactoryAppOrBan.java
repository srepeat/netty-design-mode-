package com.jcet.bean;

import com.jcet.factory.interfac.BeanFactory;
import com.jcet.factory.interfac.Fulrt;

public class FactoryAppOrBan implements BeanFactory {

	/**
	 * ʵ���࣬�����жԼ̳еĳ��󷽷�������д
	 * 
	 */
	@Override
	public Fulrt getApple() {
		// TODO Auto-generated method stub
		return new NorthApple();
	}

	@Override
	public Fulrt getBanana() {
		// TODO Auto-generated method stub
		return new NorthBanana();
	}

	
}
