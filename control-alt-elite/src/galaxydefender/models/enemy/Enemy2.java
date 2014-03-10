package galaxydefender.models.enemy;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Random;

public class Enemy2 extends Enemy {

	private Point2D direction;
	private int xrange;
	private int yrange;
	private final int NUM_STEPS = 25;
	private Random rand;
	private int step;
	private int counter;
	
	public Enemy2(Dimension d, int level) {
		this.d = d;
		this.width = 64;
		this.height = 64;
		imageFile = "../../images/enemy2.png";
		rand = new Random(System.currentTimeMillis());
		
		locationx = rand.nextDouble() * (d.getWidth()-this.width);
		locationy = 0;
		xrange = 10;
		yrange = 2;
		step = 0;
		counter = 1;
		
		switch(level) {
		case 1:
			attackRate = 35;
			speed = 3;
			break;
		case 2:
			attackRate = 30;
			speed = 5;
			break;
		case 3:
			attackRate = 25;
			speed = 7;
			break;
		}
	}
	
	@Override
	public boolean move() {
		// Recalculate a path
		if (step == 0) {
			direction = new Point2D.Double(rand.nextInt(xrange)-xrange/2, rand.nextInt(yrange)+0.1);
			// Normalize
			double distance = direction.distance(new Point2D.Double(0,0));
			direction = new Point2D.Double(direction.getX()/distance, direction.getY()/distance); 
		}
		
		if (locationx < 0 || locationx > (d.width-width)) {
			direction = new Point2D.Double(-direction.getX(), direction.getY());
		}
		
		locationx += speed * direction.getX();
		locationy += speed * direction.getY();
		counter = (counter + 1) % attackRate;
		
		if (locationy > d.getHeight()) {
			return false;
		}
		
		step++;
		if (step == NUM_STEPS) {
			step = 0;
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
