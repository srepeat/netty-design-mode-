package com.jcet.pattern.test;

import com.jcet.pattern.factory.Apple;
import com.jcet.pattern.factory.Banana;
import com.jcet.pattern.factory.Fulrt;
import com.jcet.pattern.factory.MyConfig;

public class MainTest {

	public static void main(String[] args) {
		
		//通过多态的方式实例化对象调用
		/*Fulrt apple = new Apple();
		Fulrt baner = new Banana();
		
		apple.get();
		baner.get();*/
		
//		======================================
		//通过一个配置bean的方式完成调用
		/*Fulrt apple = new MyConfig().getApple();
		Fulrt banne = new MyConfig().getBenana();
		apple.get();
		banne.get();*/
		
		
//		-------------------------------
//		通过判断bean的类型去调用方法
		try {
			Fulrt apple = MyConfig.getBeanFactory("apple");
			apple.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
