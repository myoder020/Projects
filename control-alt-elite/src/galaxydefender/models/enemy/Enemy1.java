package galaxydefender.models.enemy;

import java.awt.Dimension;
import java.util.Random;

public class Enemy1 extends Enemy{

	private Random rand;
	private int counter;
	
	public Enemy1(Dimension d, int level) {
		this.d = d;
		this.width = 64;
		this.height = 64;
		imageFile = "../../images/enemy1.png";
		rand = new Random(System.currentTimeMillis());
		locationx = rand.nextDouble() * (d.getWidth()-this.width);
		locationy = 50;
		
		switch (level) {
		case 1:
			speed = 10;
			attackRate = 35;
			break;
		case 2:
			speed = 15;
			attackRate = 30;
			break;
		case 3:
			speed = 20;
			attackRate = 25;
			break;
		}
		counter = 1;
	}
	
	@Override
	public boolean move() {
		if ( locationx < 0 || locationx > (d.width-this.width)) {
			speed = -speed;
		}
		
		locationx += speed;
		locationy += 2;
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
