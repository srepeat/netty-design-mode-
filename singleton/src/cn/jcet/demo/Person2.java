package cn.jcet.demo;
/**
 * 单例模式--懒汉模式
 * @author 鲜磊
 *
 */

public class Person2 {

	private String name;
	
	private static Person2 person;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	//饿汉模式有线程不安全问题
	public static synchronized Person2 getPerson() {
		if (person == null) {
			return new Person2();
		}
		return person;
	}
	
	
	
}
