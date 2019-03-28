package com.jcet.bean;

import com.jcet.factory.interfac.BeanFactory;
import com.jcet.factory.interfac.Fulrt;

public class FactoryAppOrBan implements BeanFactory {

	/**
	 * 实现类，来进行对继承的抽象方法进行重写
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
