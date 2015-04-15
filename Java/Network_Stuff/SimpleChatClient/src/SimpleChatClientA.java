/**
 * Created by Yoder on 7/2/2014.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JButton send = new JButton("Send");
        send.addActionListener(new SendButtonListener());
        outgoing = new JTextField(20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.add(outgoing);
        mainPanel.add(send);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
        setUpNetworking();
    }

    public void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 4242);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Networking established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//close setUpNetworking method

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }//close inner class

    public static void main(String[] args) {
        SimpleChatClientA client = new SimpleChatClientA();
        client.go();
    }
}
