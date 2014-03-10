package galaxydefender.controllers;

import galaxydefender.models.weapon.BasicMissile;
import galaxydefender.models.weapon.PowerMissile;
import galaxydefender.models.weapon.SpecialMissile;
import galaxydefender.models.weapon.Weapon;
import galaxydefender.views.weapon.WeaponView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeaponController implements ActionListener {

	Weapon w;
	WeaponView wv;
	
	//changed to use GalaxyLayeredPane
	public WeaponController(Weapon w, WeaponView wv) {
		this.w = w;
		this.wv = wv;
	}
	
	@Override
	public void actionPerformed(ActionEvent action) {
		
		if(w instanceof BasicMissile){
			if(((BasicMissile)w).move()) {
				wv.repaint();
			}
		} else if(w instanceof PowerMissile) {
			if(((PowerMissile)w).move()) {
				wv.repaint();
			}
		} else if(w instanceof SpecialMissile) {
			if (((SpecialMissile)w).move()) {
				wv.repaint();
			}
		}
	}
}
