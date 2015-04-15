package galaxydefender.views.ship;

import galaxydefender.controllers.ShipController;
import galaxydefender.views.Sprite;
import galaxydefender.models.ship.Ship;

import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ShipView extends JLabel{
	
	private Ship ship;
	
	public ShipView(Ship ship){
		this.setIcon(new Sprite("../images/ship"+ship.getColor()+".gif", 50, 50));
		this.setSize(50,50);
		this.ship = ship;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setLocation(ship.getLocation());
	}
	
	public void registerListener(ShipController shipC){
		try{
			this.getRootPane().getParent().addKeyListener(shipC);
		} catch (Exception NullPointerException){
			System.err.println("Need to add ship view to container before registering listener");
			System.exit(-1);
		}
	}

}
