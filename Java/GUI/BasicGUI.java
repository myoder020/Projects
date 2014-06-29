import javax.swing.*;
import java.awt.*;


public class BasicGUI {

    public static void main(String[] args) {
        BasicGUI gui = new BasicGUI();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame();
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField field = new JTextField();
        field.setText("This is some text");
        frame.getContentPane().add(BorderLayout.EAST, field);
        frame.setVisible(true);
    }

}
