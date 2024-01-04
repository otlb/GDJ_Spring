package com.winter.app.ioc;

public abstract class Arm {

	
	private String direction; //왼쪽팔이냐 오른쪽팔이냐 
	
	public abstract void act();
	

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
