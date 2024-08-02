/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uj.amc;

/**
 *
 * @author asus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class welcome extends JPanel {

    private Image backgroundImage;
    
     
    public welcome() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 650);
        f.setTitle("MyMovie Application");
        
        try {
            welcome panel = new welcome("back.png");
            f.getContentPane().add(panel);
            
            // Create the menu bar
            JMenuBar menuBar = new JMenuBar();

            // Create the option menu
            JMenu optionMenu = new JMenu("Options");

            // Create the menu items
            JMenuItem exitMenuItem = new JMenuItem("Exit");
            JMenuItem helpMenuItem = new JMenuItem("Help");
            JMenuItem feedbackMenuItem = new JMenuItem("Feedback");

            // Add the menu items to the option menu
            optionMenu.add(exitMenuItem);
            optionMenu.add(helpMenuItem);
            optionMenu.add(feedbackMenuItem);

            // Add the option menu to the menu bar
            menuBar.add(optionMenu);

            // Set the menu bar for the frame
            f.setJMenuBar(menuBar);

            // Add action listeners to the menu items
            exitMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Perform exit action
                    System.exit(0);
                }
            });

            helpMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   
                    JOptionPane.showMessageDialog(f, "Visit our website for tutorials,"
                            + " video guides, and community forums to get expert advice and support."
                            , "Help", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            });

            feedbackMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    JOptionPane.showInputDialog(f, "                                We value your feedback! \nPlease share your thoughts,"
                            + " suggestions, or report any issues \n                  you've encountered using our application."
                            , "Feedback", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
     public welcome(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
        setLayout(new FlowLayout(FlowLayout.LEFT,150,525));
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Dimension buttonSize = new Dimension(100, 40);
        startButton.setPreferredSize(buttonSize);
        startButton.setForeground(Color.decode("#B22222"));
        startButton.setBackground(Color.decode("#D2B48C"));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event
             if(e.getSource()==startButton){
            Customerinfom info = new Customerinfom();
            info.setVisible(true);
            JFrame welcomeFrame = (JFrame) SwingUtilities.getWindowAncestor(welcome.this);
            welcomeFrame.setVisible(false);
            
        }
                
    }
        });
             add(startButton);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
        g.setFont(new Font( "Times New Roman", Font.BOLD,30));
        g.setColor(Color.WHITE);
        g.drawString("Welcome to MyMovie", 66, 245);
        g.drawString("Application", 125, 273);
        
    }

    

    
}

    
  