package galaxydefender.models.enemy;

import galaxydefender.views.ship.ShipView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JLabel;

public class Attack extends JLabel {

	private static final long serialVersionUID = 1L;
	int width;
	int height;
	double locationx;
	double locationy;
	double directionx;
	double directiony;
	final int speed = 10;
	final int spread = 50;
	Random rand;
	Dimension d;
	
	public Attack(Enemy e, ShipView s, Dimension d) {
		this.d = d;
		this.width = 10;
		this.height = 10;
		
		locationx = e.getX() + e.getWidth()/2 - this.width/2;
		locationy = e.getY() + e.getHeight();
		
		rand = new Random();
		double perturbation = rand.nextDouble()*spread - spread/2.0;
		
		directionx = (s.getX() + s.getWidth()/2 - this.width/2) - locationx + perturbation;
		directiony = s.getY() - locationy;
		
		double distance = Math.sqrt(directionx*directionx + directiony*directiony);
		directionx /= distance;
		directiony /= distance;
		
		setSize((int)d.getWidth(), (int)d.getHeight());
	}
	
	public boolean move() {
		locationx += speed * directionx;
		locationy += speed * directiony;
		
		if (locationy > d.getSize().getHeight() || locationx < 0 || locationx > d.getWidth()) {
			return false;
		}
		return true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect((int)locationx, (int)locationy, 10, 10);
	}
}
