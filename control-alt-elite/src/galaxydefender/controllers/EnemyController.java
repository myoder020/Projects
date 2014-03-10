package galaxydefender.controllers;

import galaxydefender.models.enemy.Attack;
import galaxydefender.models.enemy.Enemy;
import galaxydefender.models.enemy.Enemy1;
import galaxydefender.models.enemy.Enemy2;
import galaxydefender.models.enemy.Enemy3;
import galaxydefender.views.enemy.EnemyView;
import galaxydefender.views.ship.ShipView;
import galaxydefender.views.window.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class EnemyController implements ActionListener {

	ArrayList<Enemy> enemies;
	ArrayList<EnemyView> enemyViews;
	ArrayList<Attack> attacks;
	GamePanel bg;
	Random rand;
	private int difficulty;
	
	//changed to use GalaxyLayeredPane
	public EnemyController(GamePanel bg, int difficulty) {
		this.bg = bg;
		this.difficulty = difficulty;
		enemies = new ArrayList<Enemy>();
		enemyViews = new ArrayList<EnemyView>();
		attacks = new ArrayList<Attack>();
		rand = new Random(System.currentTimeMillis());
		
		Enemy enemy;
		EnemyView enemyV;
		for (int i = 0; i < 5; i++) {
			enemy = getEnemy(difficulty);
			enemyV = new EnemyView(enemy);
			enemyV.setSize(bg.getSize());
		
			enemies.add(enemy);
			enemyViews.add(enemyV);
			//added second argument (the layer its added to)
			bg.add(enemyV, new Integer(1));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent action) {
		
	new Thread(new Runnable(){
			public void run(){
				//Update enemies
				for (int i = 0; i < enemies.size(); i++) {
					Enemy e = enemies.get(i);
					EnemyView ev = enemyViews.get(i);
					if (e.move()) {
						ev.repaint();
					}
					// Restart enemy
					else {
						e = getEnemy(difficulty);
						enemies.set(i, e);
						ev.setEnemy(e);
					}
					
					if (e.isAttacking()) {
						Attack attack = new Attack(e, (ShipView)bg.getComponent(0), bg.getSize());
						attacks.add(attack);
						bg.add(attack, new Integer(1));
					}
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run(){
				Iterator<Attack> iter = attacks.iterator();
				while (iter.hasNext()) {
					Attack a = iter.next();
					// Redraw
					if (a.move()) {
						a.repaint();
					}
					// Remove attack
					else {
						bg.remove(a);
						iter.remove();
					}
				}
			}
		}).start();
	}

	private Enemy getEnemy(int level) {
		int n = rand.nextInt(100);
		if (n < 30) {
			return new Enemy1(bg.getSize(), level);
		}
		else if (n < 70) {
			return new Enemy2(bg.getSize(), level);
		}
		else {
			return new Enemy3(bg.getSize(), level);
		}
	}
}
