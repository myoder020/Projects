package galaxydefender.views.window;

import galaxydefender.views.TileIcon;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class GamePanel extends JLayeredPane{
	
	//game window background
	private JLabel bg;
    
    public GamePanel(Dimension d){
    	this.setSize((int) (.8*d.width),d.height);
    	this.setPreferredSize(this.getSize());
		setOpaque(true);
        
        //animated background
		try {
		    TileIcon icon = new TileIcon(getClass().getResource("../../images/bg.gif").toURI().toURL());
			bg = new JLabel(icon);
			bg.setSize(this.getSize());
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(bg, new Integer(0));
		
	}
    
    //for resizing background on window resize
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bg.setSize(this.getWidth(),this.getHeight());
    }
    
}
