/**
 * Created by Yoder on 6/28/2014.
 */
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class FileTester {
    File f;
    BufferedWriter writer;
    JTextField field;
    PrintWriter w;

    public static void main(String[] args) {
        FileTester temp = new FileTester();
        temp.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JButton send = new JButton("Send");
        field = new JTextField(20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        send.addActionListener(new SendButtonListener());
        mainPanel.add(field);
        mainPanel.add(send);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        f = new File("myFile.txt");
        try {
            writer = new BufferedWriter(new FileWriter(f, true));
            w = new PrintWriter(writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                w.println(field.getText());
                w.flush();
            } catch (Exception ex) {
                System.out.println("Couldn't write to file");
                ex.printStackTrace();
            } finally {
                w.close();
            }
            field.setText("");
            field.requestFocus();
        }
    }

}
