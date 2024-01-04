package com.winter.app.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class RobotMain {

	public static void main(String[] args) {
//		Robot robot = new Robot();
//		
//		robot.getLeftArm().act();
//		
//		robot = null;
//		//생성자 
//		LeftArm leftArm = new LeftArm();
//		RightArm rightArm = new RightArm();
//		
//		robot = new Robot(leftArm,rightArm);
//
//		
//		//setter
//		robot.setLeftArm(leftArm);
		
		
		Robot robot = new Robot();
		Robot robot2 = new Robot(null, null);
		robot.getLeftArm().act();
	}

}
