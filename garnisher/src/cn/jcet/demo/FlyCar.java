package cn.jcet.demo;

/**
 * װ����ģʽ��ͨ��һ�����еĽӿڷ�����ʵ����ʵ�����������
 * д��ǰ�ķ�����ʹ��ʵ�ַ������õ�ǰ�ķ��� ==> Ȼ���ڵ��õ�ʱ��ʹ�ö�̬�ķ�ʽ
 * @author ����
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
		//���õ�ǰ��ķ���
		this.run();
		this.fly();
	}
}