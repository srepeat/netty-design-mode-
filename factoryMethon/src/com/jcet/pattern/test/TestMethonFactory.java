package com.jcet.pattern.test;

import com.jcet.factory.interfac.FacroryBean;
import com.jcet.factory.interfac.Fulrt;
import com.jcet.pattern.factory.AppleFactory;

public class TestMethonFactory {

	public static void main(String[] args) {
		//通过抽象方法模式进行调用
		//通过接口来创建所需要实例化的工厂
		FacroryBean fb = new AppleFactory();
		//通过创建的工厂来获取工厂实例化的对象
		Fulrt apple = fb.getFactory();
		//通过工厂获取的方法进行调用bean的方法，执行
		apple.get();
	}
}
