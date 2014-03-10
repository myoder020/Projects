package galaxydefender.controllers;

import galaxydefender.models.ship.Ship;
import galaxydefender.models.weapon.BasicMissile;
import galaxydefender.models.weapon.Weapon;
import galaxydefender.views.ship.ShipView;
import galaxydefender.views.weapon.WeaponView;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/*
 * Ship class holding information about the player's current ship
 * 
 * truth table
 * w a s d
 * 0 0 0 0 at rest = 0
 * 0 0 0 1 right = 1
 * 0 0 1 0 down = 2
 * 0 0 1 1 down right = 3
 * 0 1 0 0 left = 4
 * 0 1 1 0 down left = 6
 * 1 0 0 0 up = 8
 * 1 0 0 1 up right = 9
 * 1 1 0 0 up left = 12
 */
public class ShipController implements KeyListener {
	private Ship currentShip;
	private ShipView shipV;
	private int bitString;
	private boolean fireBasic = false;
	private Long lastFired;
	private boolean boosting = false;
	private int speed = 10;
	
	public ShipController(Ship ship, ShipView shipV) {
		currentShip = ship;
		this.shipV = shipV;
        //Swing timer check every 30ms if there's keys pressed
        new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(bitString != 0)
                	move();
                if(fireBasic) {
                	fire(BasicMissile.getReFire());
                }
                if(boosting == true && currentShip.hasBoost()) {
                	speed = 20;
                	currentShip.boost();
                } else {
                	speed = 10;
                }
            }
        }).start();
	}
	
	public void fire(int refire) {
		if(lastFired == null || System.currentTimeMillis() - lastFired >= refire){
			lastFired = System.currentTimeMillis();
			final Weapon w = new BasicMissile(new Point(currentShip.getX(), currentShip.getY()));
			WeaponView wv = new WeaponView(w);
			WeaponController wc = new WeaponController(w, wv);
			//third .add argument specifies priority in layer
			//higher means place underneath other stuff
			shipV.getParent().add(wv, new Integer(1), new Integer(2));
			//after adding to game pane dispose of graphic to free memory; not sure this works right...
			wv.getGraphics().dispose();
			new Timer(20, wc).start();
		}
	}
	
	//this part works by using or on the correct bitString
	@Override
	public void keyPressed(KeyEvent key) {
		switch(key.getKeyChar()) {
		case 'b':
			boosting=true;
			break;
		case KeyEvent.VK_SPACE:
			fireBasic=true;
			break;
		case 'w':
			this.bitString = this.bitString | 8;
			break;
		case 'a': 
			this.bitString = this.bitString | 4;
			break;
		case 's':
			this.bitString = this.bitString | 2;
			break;
		case 'd':			
			this.bitString = this.bitString | 1;
			break;
		}
	}

	//this part works by using xor on the correct bitString
	@Override
	public void keyReleased(KeyEvent key) {
		switch(key.getKeyChar()) {
		case 'b':
			boosting=false;
			break;
		case KeyEvent.VK_SPACE:
			fireBasic=false;
			break;
		case 'w':
			this.bitString = this.bitString ^ 8;
			break;
		case 'a': 
			this.bitString = this.bitString ^ 4;
			break;
		case 's':
			this.bitString = this.bitString ^ 2;
			break;
		case 'd':			
			this.bitString = this.bitString ^ 1;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	//move uses truth table
	private void move(){
		switch(this.bitString) {
		//up
		case 8:	moveUp(); break;
		//left
		case 4: moveLeft(); break;
		//down
		case 2:	moveDown();	break;
		//right
		case 1:	moveRight(); break;
		//down right
		case 3:	moveDown(); moveRight(); break;
		//down left		
		case 6: moveDown(); moveLeft(); break;
		//up right
		case 9: moveUp(); moveRight(); break;
		//up left
		case 12: moveUp(); moveLeft(); break;
		//at rest or other
		default: return;
		}
		shipV.repaint();
	}
	
	private void moveUp(){
		if(currentShip.getY() > currentShip.getWindowHeight()/2)
			currentShip.setY(currentShip.getY()-speed);
	}
	
	private void moveLeft(){
		if(currentShip.getX() > 10)
			currentShip.setX(currentShip.getX()-speed);
	}
	
	private void moveDown(){
		if(currentShip.getY() < currentShip.getWindowHeight()-50)
			currentShip.setY(currentShip.getY()+speed);
	}
	
	private void moveRight(){
		if(currentShip.getX() < currentShip.getWindowWidth()-60)
			currentShip.setX(currentShip.getX()+speed);
	}
}
