package cn.jcet.demo;
/**
 * ����ģʽ--����ģʽ
 * @author ����
 *
 */

public class Person {

	private String name;
	
	private static final Person person = new Person();

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

	public static Person getPerson() {
		return person;
	}
	
	
	
}