package cn.jcet;

import cn.jcet.demo.Person;

public class TestMain {

	public static void main(String[] args) {
		//单例模式  不管有几个对象，但最终都只有一个,只允许一个线程
		Person person = Person.getPerson();
		person.setName("李四");
		person.setName("张三");
		person.setName("李四");
		System.out.println(person);
		
	}
}
