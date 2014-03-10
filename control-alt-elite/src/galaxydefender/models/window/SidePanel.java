package galaxydefender.models.window;

public class SidePanel {
    /**
     * Integer representing current panel
     */
    private int panel;

    /**
     * Initial panel is 1 the main menu
     */
    public SidePanel() {
        this.panel = 1;
    }

    /**
     * @return the value of panel
     */
    public int whichPanel() {
        return this.panel;
    }

    /**
     * Switch to specified panel
     */
    public void switchPanel(int panel) {
    	this.panel = panel;
    }
}
