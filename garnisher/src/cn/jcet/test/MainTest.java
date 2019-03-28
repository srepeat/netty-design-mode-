package cn.jcet.test;

import cn.jcet.demo.Car;
import cn.jcet.demo.FlyCar;

/**
 * 测试装饰者模式
 * @author 鲜磊
 *
 */
public class MainTest {

	public static void main(String[] args) {
		
		Car car = new FlyCar();
		car.show();
		
		
	}
}
