package galaxydefender.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Sprite extends ImageIcon{
	private Image img;
	private Dimension size = new Dimension();
	
	public Sprite(String imgPath, int width, int height){
		this(getImageURL(imgPath), width, height);
	}
	
	public Sprite(String imgPath, Dimension size){
		this(getImageURL(imgPath), size.width, size.height);
	}
	
	public Sprite(URL location, Dimension size){
		this(location,size.width,size.height);
	}
	
	public Sprite(URL location, int width, int height){
		this.setSize(width, height);
		//set image to location; this is one way I found for animated gifs to be animated
        this.img = Toolkit.getDefaultToolkit().getImage(location);
        if (this.img == null)
        	return;
        this.loadImage(this.img);
	}
	
	private static URL getImageURL(String imgPath){
		try {
			return Sprite.class.getResource(imgPath).toURI().toURL();
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	//overridden to include width and height
	public void paintIcon(Component c, Graphics g, int x, int y){
        if(this.getImageObserver() == null) {
        	g.drawImage(this.img, x, y, this.getIconWidth(), this.getIconHeight(), c);
         } else {
         	g.drawImage(this.img, x, y, this.getIconWidth(), this.getIconHeight(), this.getImageObserver());
         }
	}
	
	public void setSize(int width, int height){
		this.size.setSize(width, height);
	}
	
	@Override
	public int getIconHeight() {
		return size.height;
	}
	
	@Override
	public int getIconWidth() {
		return size.width;
	}
	
	public Dimension getIconSize() {
		return size;
	}
	
	
}
