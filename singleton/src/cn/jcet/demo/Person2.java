package cn.jcet.demo;
/**
 * ����ģʽ--����ģʽ
 * @author ����
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

	//����ģʽ���̲߳���ȫ����
	public static synchronized Person2 getPerson() {
		if (person == null) {
			return new Person2();
		}
		return person;
	}
	
	
	
}