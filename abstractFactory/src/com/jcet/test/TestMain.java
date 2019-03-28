package com.jcet.test;

import com.jcet.bean.FactoryAppOrBan;
import com.jcet.factory.interfac.BeanFactory;
import com.jcet.factory.interfac.Fulrt;

public class TestMain {

	public static void main(String[] args) {
		//多态的方式new实现类
		BeanFactory bf = new FactoryAppOrBan();
		//使用重写方法返回实例化对象，调用方法的通过也就在实例化对象的过程
		Fulrt apple = bf.getApple();
		Fulrt banana = bf.getBanana();
		//获取返回对象调用抽象方法
		apple.get();
		banana.get();
	}
}
