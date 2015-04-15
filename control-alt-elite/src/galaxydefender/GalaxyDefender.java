package galaxydefender;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import galaxydefender.controllers.SidePanelController;
import galaxydefender.models.window.SidePanel;
import galaxydefender.views.window.GamePanel;
import galaxydefender.views.window.SidePanelView;

public class GalaxyDefender {
    
	public static void main(String[] args) {
		 JFrame w = new JFrame("Galaxy Defender");
		 w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 w.setSize(1200, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-40));
		 
		 GamePanel rightView = new GamePanel(w.getSize());
		 
		 SidePanel leftModel = new SidePanel();
		 SidePanelView leftView = new SidePanelView(new Dimension((int) (.2*w.getWidth()),w.getHeight()),rightView);
		 SidePanelController leftController = new SidePanelController(leftView, leftModel);
		 leftView.register(leftController);
		 
		 w.getContentPane().add(rightView);
		 w.getContentPane().add(leftView, BorderLayout.EAST);
		 
		 w.setVisible(true);
		 w.setFocusable(true);
	}
}
