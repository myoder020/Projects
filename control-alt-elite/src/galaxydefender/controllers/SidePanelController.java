package galaxydefender.controllers;

import galaxydefender.models.window.SidePanel;
import galaxydefender.views.window.SidePanelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanelController implements ActionListener{
	private SidePanel model;
	private SidePanelView view;
	
	/**
	 * @param view
	 * @param model
	 */
	public SidePanelController(SidePanelView view, SidePanel model){
		this.model = model;
		this.view = view;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Save Options":
			model.switchPanel(1);
			break;
		case "Start":
			model.switchPanel(2);
			break;
		case "Options":
			model.switchPanel(3);
			break;
		case "Quit":
			System.exit(0);
		}
		view.displayPanel(model.whichPanel());
	}
}
