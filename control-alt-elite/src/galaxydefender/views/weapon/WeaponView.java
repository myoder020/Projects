package galaxydefender.views.weapon;

import galaxydefender.views.Sprite;
import galaxydefender.models.weapon.BasicMissile;
import galaxydefender.models.weapon.PowerMissile;
import galaxydefender.models.weapon.SpecialMissile;
import galaxydefender.models.weapon.Weapon;
import java.awt.Graphics;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WeaponView extends JLabel{
	
	private Weapon weapon;
	
	public WeaponView(Weapon weapon){
		if(weapon instanceof BasicMissile) {
			this.weapon = (BasicMissile) weapon;
		}
		else if(weapon instanceof PowerMissile) {
			this.weapon = (PowerMissile) weapon;
		}
		else if(weapon instanceof SpecialMissile) {
			this.weapon = (SpecialMissile) weapon;
		}
		this.setIcon( new Sprite(weapon.getImageLocation(),50,50));
		this.setSize(50,50);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setLocation(weapon.getLocation());
	}

}
