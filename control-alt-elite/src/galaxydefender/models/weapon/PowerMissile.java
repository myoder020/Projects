package galaxydefender.models.weapon;

import java.awt.Point;

public class PowerMissile extends Weapon {

	public PowerMissile(int x, int y){
		this.location = new Point(x, y);
		image = "../../images/missle.png";
		speed = 10;
		reFire = 300;
	}
	
	public PowerMissile(Point p) {
		this((int) p.getX(), (int) p.getY());
	}

	@Override
	public boolean move() {
		
		location.y -= speed;
		
		if (location.y < 0) {
			return false;
		}
		return true;
	}

}
