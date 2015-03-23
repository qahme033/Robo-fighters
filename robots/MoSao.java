package rjpm;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html


/**
 * MoSao - a robot by (your name here)
 */
public class MoSao extends Robot
{
	public ScannedRobotEvent other = null;
	/**
	 * run: MoSao's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			scanEnemy();
		}
	}

	public void scanEnemy(){
		
		turnRadarLeft(360);
		/*if(other == null){
			turnRadarRight(360);
		} else {
		 	turnRadarRight(getHeading() - getGunHeading() + other.getBearing() - 20);
			turnRadarRight(getHeading() - getGunHeading() + other.getBearing() + 40);
		}*/

	}
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		//turnGunRight(getHeading() - getGunHeading() + e.getBearing());
		save(e);
		//double aimingAngle = calculateAimingAngle();
		aim(e.getBearing());
		fire(getEnergy() * 0.25);
	}
	
	private double calculateAimingAngle(){
		other.getDistance();
		return 0.0;
	}

	private void save(ScannedRobotEvent e){
		other = e;
	}
	
	private void aim(double angle){
		//currentPosition
		double pangle = java.lang.Math.toRadians((getHeading() + angle) % 360);
		double eX = getX() + java.lang.Math.sin(pangle) * other.getDistance();
		double eY = getY() + java.lang.Math.cos(pangle) * other.getDistance();	


		double rangle = (getHeading() - getGunHeading() + angle)%360;
		if( rangle  == 0){
			; // Do nothing
		} else if( java.lang.Math.abs(rangle) < 180 ){
			turnGunRight(rangle);
		} else if(rangle > 0){
			turnGunRight(rangle - 360);
		} else {
			turnGunRight(360 + rangle);
		}
		/*} else if(java.lang.Math.abs(rangle) < 90){
			turnGunRight(rangle);
		} else if(rangle <= -90){
			sturnGunRight((rangle + 360)%360);
		} else {
			turnGunRight(rangle);
		}*/
		

		//turnGunRight(getHeading() - getGunHeading() + angle);
	}
	
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
