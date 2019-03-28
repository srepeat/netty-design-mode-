package com.jcet.pattern.test;

import com.jcet.pattern.factory.Apple;
import com.jcet.pattern.factory.Banana;
import com.jcet.pattern.factory.Fulrt;
import com.jcet.pattern.factory.MyConfig;

public class MainTest {

	public static void main(String[] args) {
		
		//ͨ����̬�ķ�ʽʵ�����������
		/*Fulrt apple = new Apple();
		Fulrt baner = new Banana();
		
		apple.get();
		baner.get();*/
		
//		======================================
		//ͨ��һ������bean�ķ�ʽ��ɵ���
		/*Fulrt apple = new MyConfig().getApple();
		Fulrt banne = new MyConfig().getBenana();
		apple.get();
		banne.get();*/
		
		
//		-------------------------------
//		ͨ���ж�bean������ȥ���÷���
		try {
			Fulrt apple = MyConfig.getBeanFactory("apple");
			apple.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
