package galaxydefender.models.enemy;

import java.awt.Dimension;

public abstract class Enemy {

	protected int width;
	protected int height;
	protected double locationx;
	protected double locationy;
	protected Dimension d;
	protected String imageFile;
	protected double speed;
	protected int attackRate;
	
	public abstract boolean move();
	
	public abstract boolean isAttacking();
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return (int) locationx;
	}
	
	public int getY() {
		return (int) locationy;
	}

	public int getWidth() {
		return width;
	}
	
	public String getImageFile() {
		return imageFile;
	}
}
