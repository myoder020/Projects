package galaxydefender.views.window;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> col;
	private JComboBox<String> dif;
	private JButton button;
	
	public OptionsScreen(Dimension d) {
		String[] colors = {"White", "Red", "Blue", "Green", "Yellow", "Pink", "Teal", "Orange", "Purple"};
		String[] difficulty = {"Easy", "Medium", "Hard"};
		
		JLabel title = new JLabel("Options");
		
		title.setFont(new Font(title.getName(), Font.BOLD, 18));
		JLabel label = new JLabel("Ship Color: ");
		JLabel label2 = new JLabel("Difficulty: ");
        col = new JComboBox<String>(colors);
        dif = new JComboBox<String>(difficulty);
        col.setSelectedIndex(0);
        dif.setSelectedIndex(0);
        
        button = new JButton("Save Options");
        
        
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
        c.ipadx = 150;
        c.ipady = 10;
        c.gridy = 0;
        c.gridx = 0;
        this.add(title, c);
        
        c.ipady = 5;
        c.gridy = 1;
        this.add(label, c);
        
        c.gridy = 2;
        this.add(col, c);
        
        c.gridy = 3;
        this.add(label2, c);
        
        c.gridy = 4;
        this.add(dif, c);
        
        c.insets = new Insets(10,0,0,0);
        c.ipady = 20;
        c.ipadx = 105;
        c.gridy = 5;
        this.add(button, c);
        
        c.weighty=1;
        JLabel space = new JLabel();
        space.setOpaque(false);
        this.add(space,c);
        
        setOpaque(false);
	}

	public String getColor() {
		String color = col.getSelectedItem().toString().toLowerCase();
		return color.equals("white") ? "" : color;
	}
	
	public int getDifficulty() {
		String diff = dif.getSelectedItem().toString().toLowerCase();
		switch(diff) {
			case "easy":
				return 1;
			case "medium":
				return 2;
			case "hard":
				return 3;
			default:
				return 1;
		}
	}
	
	public JButton getButton() {
		return button;
	}
}
