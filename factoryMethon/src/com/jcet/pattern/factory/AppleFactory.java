package com.jcet.pattern.factory;

import com.jcet.factory.interfac.FacroryBean;
import com.jcet.factory.interfac.Fulrt;

public class AppleFactory implements FacroryBean{

	@Override
	public Fulrt getFactory() {
		// TODO Auto-generated method stub
		return new Apple();
	}

}
