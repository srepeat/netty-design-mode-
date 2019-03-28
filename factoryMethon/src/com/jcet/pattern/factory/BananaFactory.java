package com.jcet.pattern.factory;

import com.jcet.factory.interfac.FacroryBean;
import com.jcet.factory.interfac.Fulrt;
/**
 * 实现工厂接口方法，类实现总接口方法
 * @author 鲜磊
 *
 */
public class BananaFactory implements FacroryBean {

	@Override
	public Fulrt getFactory() {
		// TODO Auto-generated method stub
		return new Banana();
	}

}
