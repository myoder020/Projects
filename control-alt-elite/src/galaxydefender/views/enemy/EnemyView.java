package galaxydefender.views.enemy;

import galaxydefender.models.enemy.Enemy;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class EnemyView extends JLabel {

	private static final long serialVersionUID = 1L;
	private Enemy enemy;
	private Image enemyImage;
	
	public EnemyView (Enemy enemy) {
		BufferedImage enemyImage = null;
		try {
			enemyImage = ImageIO.read(new File(getClass().getResource(enemy.getImageFile()).toURI()));
		 } catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		 }
		this.enemyImage = enemyImage;
		this.enemy = enemy;
	}
	
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
		// Use image corresponding to new enemy
		try {
			enemyImage = ImageIO.read(new File(getClass().getResource(enemy.getImageFile()).toURI()));
		 } catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		 }
	}
	
	@Override
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		g.drawImage(enemyImage, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(), null);
		//System.out.println("draw " + enemy.getX() + "," + enemy.getY());
	}
}
