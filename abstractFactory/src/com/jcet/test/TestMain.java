package com.jcet.test;

import com.jcet.bean.FactoryAppOrBan;
import com.jcet.factory.interfac.BeanFactory;
import com.jcet.factory.interfac.Fulrt;

public class TestMain {

	public static void main(String[] args) {
		//��̬�ķ�ʽnewʵ����
		BeanFactory bf = new FactoryAppOrBan();
		//ʹ����д��������ʵ�������󣬵��÷�����ͨ��Ҳ����ʵ��������Ĺ���
		Fulrt apple = bf.getApple();
		Fulrt banana = bf.getBanana();
		//��ȡ���ض�����ó��󷽷�
		apple.get();
		banana.get();
	}
}
