package com.jcet.pattern.factory;

import com.jcet.factory.interfac.FacroryBean;
import com.jcet.factory.interfac.Fulrt;
/**
 * ʵ�ֹ����ӿڷ�������ʵ���ܽӿڷ���
 * @author ����
 *
 */
public class BananaFactory implements FacroryBean {

	@Override
	public Fulrt getFactory() {
		// TODO Auto-generated method stub
		return new Banana();
	}

}
