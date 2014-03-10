package galaxydefender.models.enemy;

import java.awt.Dimension;
import java.util.Random;

public class Enemy3 extends Enemy {
	
	private double theta;
	private int verticalDist;
	private int counter;
	private Random rand;
	
	public Enemy3 (Dimension d, int level) {
		this.d = d;
		imageFile = "../../images/enemy3.png";
		rand = new Random();
		theta = rand.nextDouble()*3;
		verticalDist = 50;
		
		counter = 1;
		this.width = 64;
		this.height = 64;
		locationx = d.getWidth() / 2;
		locationy = verticalDist;
		
		switch(level) {
		case 1:
			attackRate = 35;
			speed = 0.03;
			break;
		case 2:
			attackRate = 30;
			speed = 0.05;
			break;
		case 3:
			attackRate = 25;
			speed = 0.08;
			break;
		}
	}
	
	@Override
	public boolean move() {
		locationx = 0.9*(d.getWidth()-width)/2*Math.sin(theta) + (d.getWidth()-width)/2;
		locationy = 100 * Math.sin(2*theta) + verticalDist;
		
		theta += speed;
		verticalDist += 2;
		counter = (counter + 1) % attackRate;
		
		if (locationy + this.height > d.getHeight()) {
			return false;
		}
		return true;
			
	}

	@Override
	public boolean isAttacking() {
//		return true;
		if (counter == 0) {
			return true;
		}
		return false;
	}

}
