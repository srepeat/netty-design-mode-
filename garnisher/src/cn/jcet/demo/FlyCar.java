package cn.jcet.demo;

/**
 * 装饰者模式，通过一个共有的接口方法，实现类实现这个方法，
 * 写当前的方法并使用实现方法调用当前的方法 ==> 然后在调用的时候使用多态的方式
 * @author 鲜磊
 *
 */
public class FlyCar implements Car {

	public void run() {
		System.out.println("car...run...");
	}
	
	public void fly() {
		System.out.println("car...fly...");
	}

	@Override
	public void show() {
		//调用当前类的方法
		this.run();
		this.fly();
	}
}
