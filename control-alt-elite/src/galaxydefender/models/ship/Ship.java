package galaxydefender.models.ship;

import galaxydefender.models.weapon.BasicMissile;
import galaxydefender.models.weapon.PowerMissile;
import galaxydefender.models.weapon.SpecialMissile;
import galaxydefender.models.weapon.Weapon;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
/*
 * Ship class holding information about the player's current ship
 */
public class Ship extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int health;
	private int boost;
	private String color;
	private Weapon currentWeapon;
	private ArrayList<Weapon> weaponCache;
	private Point location = new Point();
	private Dimension d = new Dimension();
	
	public Ship(Dimension d, String color) {
		this.color = color;
		health = 100;
		boost = 1000;
		location.setLocation((d.width/2) - 25,d.height-50);
		weaponCache = new ArrayList<Weapon>(
				Arrays.asList(
						new BasicMissile(location),
						new PowerMissile(location),
						new SpecialMissile(location)));
		currentWeapon = weaponCache.get(0);
		this.d.setSize((d.getWidth()), d.getHeight());
	}
	
	public void gainHealth(int gain) {
		health += gain;
	}
	
	public void loseHealth(int loss) {
		health -= loss;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void switchWeapon(int toggle) {
		if(weaponCache.get(toggle).ammo() > 0) {
			currentWeapon = weaponCache.get(toggle);
		}
	}
	
	public Point getLocation(){
		return location;
	}
	
	public void setLocation(int x, int y){
		location.setLocation(x,y);
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
	
	public int getWindowWidth(){
		return this.d.width;
	}
	
	public int getWindowHeight(){
		return this.d.height;
	}
	
	public Weapon getWeapon() {
		return currentWeapon;
	}
	
	public String getColor() {
		return color;
	}
	
	public boolean hasBoost() {
		if(boost > 0) {
			return true;
		}
		return false;
	}
	
	public void boost() {
		boost -= 5;
	}
	
	public int getBoost() {
		return boost;
	}
}
