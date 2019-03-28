package cn.jcet.test;

import cn.jcet.demo.BuilderDeviction;
import cn.jcet.demo.House;
import cn.jcet.demo.HouseBuilder;
import cn.jcet.demo.PingFanBuilder;

public class MainTest {

	public static void main(String[] args) {
		//����ʦ������Ҫ�޽��������͵Ķ�����ֻ�轫ʵ���ഴ���������ɣ�����ͨ����̬����
		HouseBuilder builder = new PingFanBuilder();
		
		BuilderDeviction deviction = new BuilderDeviction(builder);
		deviction.getHouse();
		House house = builder.getMinkHouse();
		
		System.out.println(house.getFloor());
		System.out.println(house.getHotseTop());
		System.out.println(house.getWall());
		
	}
}
