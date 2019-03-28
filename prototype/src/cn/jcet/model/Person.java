package cn.jcet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ���--ԭ��ģ��
 * @author ����
 *	ǳ��¡���ǿ�¡��һ����ַ
 *	���¡�ǿ�¡��һ�������е�����
 *
 */
public class Person implements Cloneable{
	
	private String name;
	private Integer age;
	private List<String> friends = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	@Override
	public  Person clone()  {
		try {
			//���¡��ʽ
			Person person = (Person) super.clone();
			List<String> friends = new ArrayList<>();
			//�����Ķ����ȡ��ǰ��������е�����
			for (String friend : this.getFriends()) {
				friends.add(friend);
			}
			person.setFriends(friends);
			
			//����clone�����Ķ���
			return person;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}