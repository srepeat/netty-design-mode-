package cn.jcet.test;

import cn.jcet.demo.BuilderDeviction;
import cn.jcet.demo.House;
import cn.jcet.demo.HouseBuilder;
import cn.jcet.demo.PingFanBuilder;

public class MainTest {

	public static void main(String[] args) {
		//工程师，在需要修建那种类型的东西，只需将实现类创建出来即可，都是通过多态调用
		HouseBuilder builder = new PingFanBuilder();
		
		BuilderDeviction deviction = new BuilderDeviction(builder);
		deviction.getHouse();
		House house = builder.getMinkHouse();
		
		System.out.println(house.getFloor());
		System.out.println(house.getHotseTop());
		System.out.println(house.getWall());
		
	}
}
