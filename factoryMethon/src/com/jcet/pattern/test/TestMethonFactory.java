package com.jcet.pattern.test;

import com.jcet.factory.interfac.FacroryBean;
import com.jcet.factory.interfac.Fulrt;
import com.jcet.pattern.factory.AppleFactory;

public class TestMethonFactory {

	public static void main(String[] args) {
		//ͨ�����󷽷�ģʽ���е���
		//ͨ���ӿ�����������Ҫʵ�����Ĺ���
		FacroryBean fb = new AppleFactory();
		//ͨ�������Ĺ�������ȡ����ʵ�����Ķ���
		Fulrt apple = fb.getFactory();
		//ͨ��������ȡ�ķ������е���bean�ķ�����ִ��
		apple.get();
	}
}
