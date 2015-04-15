package galaxydefender.controllers;

import galaxydefender.models.ship.Ship;
import galaxydefender.views.ship.ShipView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsController implements ActionListener {
	
	private Ship currentShip;
	private ShipView shipV;
	
	public ControlsController(Ship ship, ShipView shipV) {
		currentShip = ship;
		this.shipV = shipV;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		switch(arg0.getActionCommand()) {
		case "Up":			
			if(currentShip.getY() > currentShip.getWindowHeight()/2){
			   currentShip.setY(currentShip.getY()-10);
			   shipV.repaint();
			}
			break;
		case "Left": 
			if(currentShip.getX() > 10){
			   currentShip.setX(currentShip.getX()-10);
			   shipV.repaint();
			}
			break;
		case "Down":
			if(currentShip.getY() < currentShip.getWindowHeight()-50){
			   currentShip.setY(currentShip.getY()+10);
			   shipV.repaint();
			}
			break;
		case "Right":			
			if(currentShip.getX() < currentShip.getWindowWidth()-60){
			   currentShip.setX(currentShip.getX()+10);
			   shipV.repaint();
			}
			break;
		case "Quit":			
			System.exit(0);
		}
		shipV.getRootPane().getParent().requestFocus();
	}

}
