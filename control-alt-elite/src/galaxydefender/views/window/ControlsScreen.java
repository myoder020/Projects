package galaxydefender.views.window;

import galaxydefender.controllers.ControlsController;


import galaxydefender.models.ship.Ship;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlsScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton left = new JButton("Left");
	private JButton right = new JButton("Right");
	private JButton up = new JButton("Up");
	private JButton down = new JButton("Down");
	private JButton quit = new JButton("Quit");
	private GridBagConstraints c;
	
	public ControlsScreen(Dimension d, Ship ship) {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		//empty space
		JPanel space = new JPanel();
		space.setOpaque(false);
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		this.add(space,c);
		
		//spacing for buttons
		c.weighty = 0;
		c.insets = new Insets(2,2,0,0);
		
		//button width and height(tallness)
		c.ipadx = 8;
		c.ipady = 20;
		
		//aligning buttons
		c.gridx = 1;
		c.gridy = 1;		
		this.add(up, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(left, c);
		
		c.gridx = 1;
		this.add(down, c);
		
		c.gridx = 2;
		this.add(right, c);
		

		c.insets = new Insets(10,0,0,0);
		c.gridx = 0;
		c.gridy = 3;
		c.ipadx = 100;
		c.ipady = 35;
		c.gridwidth = 3;
		this.add(quit, c);
		
		c.insets = new Insets(0,0,0,0);
		c.ipadx = 8;
		c.ipady = 10;
		
        JLabel healthLabel = new JLabel("Health: " + ship.getHealth());

		c.gridy = 4;
        this.add(healthLabel, c);
        
		c.gridy = 5;
        JLabel label = new JLabel("Boost: " + ship.getBoost());
        this.add(label, c);
		
		setVisible(true);
		setBackground(Color.GRAY);
		setOpaque(false);
	}
	
	public void registerListener(ControlsController controls) {
		left.addActionListener(controls);
		right.addActionListener(controls);
		down.addActionListener(controls);
		up.addActionListener(controls);
		quit.addActionListener(controls);
	}
	
	public void addLabel(JLabel label) {
		add(label, c);
		c.gridy = c.gridy + 1;
	}

}
