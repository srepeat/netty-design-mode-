package cn.jcet.demo;
/**
 * 建造者模式是通过一个共同属性的类，然后都有着共同得特点得方法
 *    =>:例如修建房屋最基本得属性，或者车、船之类得东西
 * 我们把她共同得东西提取成一个类，将共有的方法写成一个接口，
 * 如果需要修建什么东西就将这个接口实现，并且还有把这个对象方法，
 * 这也正好得使用到了工厂模式得缩影，将要得对象返回成一个bean方法   
 * 这也就是建造者模式的好处，只需将大概版图讲明，具体实施交给具体的方法去做
 * @author 鲜磊
 *  
 */

public class House {

	//地板
	private String floor;
	//墙皮
	private String wall;
	//房顶
	private String hotseTop;
	
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getWall() {
		return wall;
	}
	public void setWall(String wall) {
		this.wall = wall;
	}
	public String getHotseTop() {
		return hotseTop;
	}
	public void setHotseTop(String hotseTop) {
		this.hotseTop = hotseTop;
	}
	
}
