import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testPic implements ActionListener{

    private testGraphics blah;
    private JFrame frame;
    private JButton colorButton;
    private JButton labelButton;

    public static void main(String[] args) {
        testPic bla = new testPic();
        bla.start();
    }

    public void start() {

        frame = new JFrame();
        blah = new testGraphics();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(blah);
        frame.setSize(1000, 1000);

        colorButton = new JButton("change circle color");
        colorButton.addActionListener(this);
        labelButton = new JButton("Change text!!");
        labelButton.addActionListener(this);
         
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER, blah);
        frame.setVisible(true);



    }

    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }


   
    
}


