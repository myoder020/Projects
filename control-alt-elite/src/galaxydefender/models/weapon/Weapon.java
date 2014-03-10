package galaxydefender.models.weapon;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class Weapon {

	protected int ammo;
	protected String image = null;
	protected Point location = new Point();
	protected int speed;
	protected static int reFire;
	
	public abstract boolean move();
	
	public Weapon() {
		ammo = 0;
	}
	
	public int ammo() {
		return 0;
	}
	
	public Point getLocation(){
		return this.location;
	}
	
	public void setLocation(int x, int y){
		this.location.setLocation(x,y);
	}
	
	public int getX(){
		return location.x;
	}
	
	public void setX(int x){
		location.x = x;
	}
	
	public int getY(){
		return location.y;
	}
	
	public void setY(int y){
		location.y = y;
	}
	
	public URL getImageLocation() {
		try {
			return Weapon.class.getResource(image).toURI().toURL();
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getImage(){
		return image;
	}
	
	public static int getReFire() {
		return reFire;
	}

}
