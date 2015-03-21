package Work;

import java.awt.Color;

import robocode.*;

/**
 * One - a robot by (your name here)
 */
public class One extends Robot
{
	
	public int count = 0;
	public double gunTurnAmp = 10;

	public void run() {
		setAllColors(Color.black);
		out.println(getName());
		//setAdjustRadarForGunTurn(true);
		while(true) {
			tryThis();
			//moveInCircle();
			
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		count = 0;
			turnRight(e.getBearing());
	//	if(e.getName().startsWith("Work"))
	//		return;
		if(e.getDistance() < 200)
			fire(100000000);
		else if(e.getDistance() < 1000)
			fire (100);
		if(e.getDistance() > 200)
			ahead(100);
		setAllColors(Color.green);
		
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like

		//back(10);
		setAllColors(Color.red);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	//	back(500);
	}	
	
	private void rightLeft(double amp, char what){
		if(what == 'R' || what == 'r'){
			turnRadarRight(amp);
			turnRadarLeft(4*amp);
			turnRadarRight(amp);
		}
		if(what == 'g' || what == 'G'){
			turnGunRight(amp);
			turnGunLeft(2 * amp);
			turnGunRight(amp);
		}
		
	}
	private void tryThis(){
		if(count < 1){
		rightLeft(gunTurnAmp, 'r');
		rightLeft(2* gunTurnAmp, 'r');
		count++;
		}
		else
		turnRadarRight(3*gunTurnAmp);	
	}
	private void moveInCircle(){
		turnRight(10);
		ahead(10);
	}
	
}
