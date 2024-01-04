package com.winter.app.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Robot {
	
	//팔 왼쪽, 오른쪽 has a 가지고있다 가 더 잘어울리기떄문에 멤버 변수로 
	
	private LeftArm leftArm;
	
	
	private RightArm rightArm;
	
	

	public Robot() {		
//		//this.leftArm = new LeftArm();
//		//this.rightArm = new RightArm();
//		
	}
	
	public Robot(LeftArm leftArm, RightArm rightArm) {
		
		this.leftArm = new LeftArm();
		this.rightArm = new RightArm();
		
	}


	public LeftArm getLeftArm() {
		return leftArm;
	}



	public void setLeftArm(LeftArm leftArm) {
		this.leftArm = leftArm;
	}



	public RightArm getRightArm() {
		return rightArm;
	}



	public void setRightArm(RightArm rightArm) {
		this.rightArm = rightArm;
	}
	
	
	//다리 
	
	

}
