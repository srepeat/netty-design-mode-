package cn.jcet.demo;

public class BuilderDeviction {

	private HouseBuilder builder;
	
	public BuilderDeviction(HouseBuilder builder) {
		this.builder = builder;
	}

	//调用方法
	public void getHouse() {
		builder.getFloor();
		builder.getWall();
		builder.getHouseTop();
	}
	
}
