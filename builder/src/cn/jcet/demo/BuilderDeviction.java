package cn.jcet.demo;

public class BuilderDeviction {

	private HouseBuilder builder;
	
	public BuilderDeviction(HouseBuilder builder) {
		this.builder = builder;
	}

	//���÷���
	public void getHouse() {
		builder.getFloor();
		builder.getWall();
		builder.getHouseTop();
	}
	
}
