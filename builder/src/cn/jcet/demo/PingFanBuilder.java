package cn.jcet.demo;

public class PingFanBuilder implements HouseBuilder{

	private House house = new House();
	
	@Override
	public void getWall() {
		// TODO Auto-generated method stub
		house.setWall("�޽�ǽƤ....");
	}

	@Override
	public void getFloor() {
		// TODO Auto-generated method stub
		house.setFloor("�޽��ذ�....");
	}

	@Override
	public void getHouseTop() {
		// TODO Auto-generated method stub
		house.setHotseTop("�޽�����....");
	}

	@Override
	public House getMinkHouse() {
		// TODO Auto-generated method stub
		return house;
	}

}
