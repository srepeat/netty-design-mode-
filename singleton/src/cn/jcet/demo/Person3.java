package cn.jcet.demo;
/**
 * 单例模式--双重检查
 * @author 鲜磊
 *
 */

public class Person3 {

	private String name;
	
	private Person3() {

	}
	
	private static Person3 person;

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
	public static synchronized Person3 getPerson() {
		if (person == null) {
			synchronized (Person3.class) {
				if(person == null) {
					return new Person3();
				}
			}
		}
		return person;
	}
	
	
	
}
