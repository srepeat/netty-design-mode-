package cn.jcet.demo;

import java.util.ArrayList;
import java.util.List;


import cn.jcet.model.Person;

public class MainTest {
	
	public static void main(String[] args) {
			
		Person person =new Person();
//		person.setName("����");	
		List<String> list = new ArrayList<>();
		list.add("����");
		list.add("zhangsan");
		person.setFriends(list);
		
		Person person2 = person.clone();
		System.out.println(person.getFriends());
		System.out.println(person2.getFriends());
		list.add("wangu");
		person.setFriends(list);
		System.out.println(person.getFriends());
		System.out.println(person2.getFriends());
	}
}
