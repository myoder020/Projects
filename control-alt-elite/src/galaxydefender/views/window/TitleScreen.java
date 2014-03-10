package galaxydefender.views.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TitleScreen extends JPanel {

	private JButton start = new JButton("Start");
	private JButton options = new JButton("Options");
	private JButton quit = new JButton("Quit");
	private JLabel title = new JLabel();
	
	public TitleScreen(Dimension d) {
		setLayout(new GridBagLayout());
		
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File(getClass().getResource("../../images/title.png").toURI()));
		 } catch (IOException e) {
			e.printStackTrace();
		 } catch (URISyntaxException e) {
			e.printStackTrace();
		}
		title.setIcon(new ImageIcon(logo.getScaledInstance((int)d.getWidth()-10, 100, Image.SCALE_SMOOTH)));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.ipady = 50;
		
		c.gridy = 0;
		this.add(title, c);

		c.insets = new Insets(0,0,10,0);
		c.ipadx = 160;
		c.gridy = 1;
		this.add(start, c);
		
		c.ipadx = 140;
		c.gridy = 2;
		this.add(options, c);
		
		c.ipadx = 167;
		c.gridy = 3;
		this.add(quit, c);
		
		JPanel space = new JPanel();
		space.setOpaque(false);
		c.weighty = 1;
		c.gridy = 4;
		this.add(space, c);
		
		setOpaque(false);
	}
	
	public JButton getStart() {
		return start;
	}
	
	public JButton getOptions() {
		return options;
	}
	
	public JButton getQuit() {
		return quit;
	}
}
