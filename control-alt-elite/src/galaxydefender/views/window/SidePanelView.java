package galaxydefender.views.window;

import galaxydefender.controllers.ControlsController;
import galaxydefender.controllers.EnemyController;
import galaxydefender.controllers.ShipController;
import galaxydefender.controllers.SidePanelController;
import galaxydefender.models.ship.Ship;
import galaxydefender.views.ship.ShipView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SidePanelView extends JPanel {
	
    private TitleScreen ts;
    private ControlsScreen cp;
    private GamePanel gw;
    private Ship ship;
    private ShipView shipView;
    private ShipController shipControl;
    private OptionsScreen os;
	
	private static final long serialVersionUID = 1L;
	
	public SidePanelView(Dimension size, GamePanel gw) {
		this.setSize(size);
		this.setPreferredSize(size);
		this.gw = gw;
		setOpaque(true);
		setBackground(Color.GRAY);
		setLayout(new GridLayout(0, 1));
		
		//add title screen
		ts = new TitleScreen(size);
		this.add(ts);
		
		//add options panel
		os = new OptionsScreen(size);
		
		this.setOpaque(true);
	}

    /**
     * 
     * @param whichPanel panel to be displayed
     */
    public void displayPanel(int whichPanel) {
    	this.removeAll();
    	//title screen
        if (whichPanel == 1) {
            this.add(ts);
        }
        //controls
        else if (whichPanel == 2) {
        	//ship
    		ship = new Ship(gw.getSize(), os.getColor());
    		shipView = new ShipView(ship);
            gw.add(shipView, new Integer(1));
            
            //ship controls
    		shipControl = new ShipController(ship, shipView);
            shipView.registerListener(shipControl);
            
            //panel controls
            cp = new ControlsScreen(this.getSize(), ship);
            cp.setOpaque(false);
    		ControlsController cpc = new ControlsController(ship, shipView);
            cp.registerListener(cpc);
            this.add(cp);
            
            //enemies
			EnemyController enemyC = new EnemyController(gw, os.getDifficulty());
            new Timer(50, enemyC).start();
        }
        //options
        else if (whichPanel == 3) {
        	this.add(os);
        }
        this.validate();
        this.repaint();
    }

	/**import java.awt.Color;
import java.awt.Component;
	 * Adds action listener to button
	 * 
	 * @param controller
	 */
	public void register(SidePanelController controller) {
		ts.getStart().addActionListener(controller);
		ts.getOptions().addActionListener(controller);
		ts.getQuit().addActionListener(controller);
		os.getButton().addActionListener(controller);
	}

}
