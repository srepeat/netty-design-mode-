package cn.jcet;

import cn.jcet.demo.Person;

public class TestMain {

	public static void main(String[] args) {
		//����ģʽ  �����м������󣬵����ն�ֻ��һ��,ֻ����һ���߳�
		Person person = Person.getPerson();
		person.setName("����");
		person.setName("����");
		person.setName("����");
		System.out.println(person);
		
	}
}