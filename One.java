package Work;

import java.awt.Color;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * One - a robot by (your name here)
 */
public class One extends Robot
{
	/**
	 * run: One's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
		//	ahead(100);
			turnGunRight(360);
			//back(100);
			turnGunRight(360);
		}
	}
	double perpendicular(double angle){
	
		double sol1, sol2;
		sol1 = angle - 90;
		sol2 = angle + 90;
		if(Math.abs(this.getHeading() - sol1) < Math.abs(this.getHeading() - sol2))
			return sol1;
		else
			return sol2;
	}
		void dodge(double otherDir){
	//	double otherDir = e.getRobotHeadingDegrees();
		if(Math.abs(otherDir - getHeading())<360){
		double angleTo = perpendicular(otherDir);
		headTo(angleTo);
		}
		for(int i = 0; i < 1; i++){
			ahead(100);
			back(50);
		}
	}
	

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		turnToBot();
		ahead(100);
		setAllColors(Color.green);
		//fire(1);
		setAllColors(Color.BLUE);
	//	dodge(e.getRobotHeadingDegrees());
	}
	void headTo(double angle){
		double currentAngle = getHeading();
		double remain = angle - currentAngle;
		turnRight(remain);
	}
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like

		back(10);
		setAllColors(Color.red);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
	
	private void turnToBot(){
		double gDir = getGunHeading();
		double bDir = getHeading();
		Double difference = new Double(bDir - gDir);
		
		if(Math.abs(difference) < 180)
			turnRight(difference);
		else
			turnLeft(difference);
		
//		if(difference > 0){
//			if(difference < 180)
//				turnRight(difference);
//			else
//				turnLeft(difference);
//		}
//		else{
//			difference = Math.abs(difference);
//			if(difference < 180)
//				turnLeft(difference);
//			else
//				turnRight(difference);
//		}
	}
}
