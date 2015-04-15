/**
 * Created by Yoder on 7/6/2014.
 */
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ReadFile {
    JFrame frame;
    JPanel mainPanel;

    public static void main(String[] args) {
        ReadFile gui = new ReadFile();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        mainPanel = new JPanel();
        JButton button = new JButton();
        JMenuBar menuBar = new JMenuBar();
        JMenu options = new JMenu("Options");
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new SaveListener());
        options.add(save);
        menuBar.add(options);
        mainPanel.add(menuBar);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "you clicked save");
        }
    }
}
