package cn.jcet.demo;

public class PingFanBuilder implements HouseBuilder{

	private House house = new House();
	
	@Override
	public void getWall() {
		// TODO Auto-generated method stub
		house.setWall("修建墙皮....");
	}

	@Override
	public void getFloor() {
		// TODO Auto-generated method stub
		house.setFloor("修建地板....");
	}

	@Override
	public void getHouseTop() {
		// TODO Auto-generated method stub
		house.setHotseTop("修建房顶....");
	}

	@Override
	public House getMinkHouse() {
		// TODO Auto-generated method stub
		return house;
	}

}
