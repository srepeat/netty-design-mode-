package com.jcet.pattern.factory;

import com.jcet.factory.interfac.Fulrt;

public class MyConfig {

	public Fulrt getApple() {
		System.out.println("Fulrt.....");
		return new Apple();
	}
	
	public Fulrt getBenana() {
		return new Banana();
	}
	
	//ͨ���ж������е��õķ�ʽ
	public static Fulrt getBeanFactory(String type) throws Exception {
		if (type.equalsIgnoreCase("apple")) {
			return Apple.class.newInstance();
		}else if (type.equalsIgnoreCase("banana")) {
			return Banana.class.newInstance();
		}else {
			System.out.println("ʲô��û�С�������");
			return null;
		}
	}
	
	
	public static Fulrt getBeanClassName(String type) {
		Class<?> forName=null;
		try {
			forName = Class.forName(type);
			return (Fulrt) forName.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
