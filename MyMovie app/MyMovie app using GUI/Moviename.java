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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author 96656
 */
public class Moviename extends JFrame implements Serializable {
    private JRadioButton movie1;
    private JRadioButton movie2;
    private JRadioButton movie3;
    private JButton Next;
    private JLabel d3;
    private JLabel d4;
    private JTextArea slected;
    private String c;
    private Panel panel;
    
    public Moviename(){
        setTitle("Available Movies ");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(30,40));
        
        Panel panel1 = new Panel(new FlowLayout(FlowLayout.CENTER,120,44));
        panel1.setBackground(Color.decode("#F0DEB5"));
        Panel panel3 = new Panel(new GridLayout(3,1));
        panel3.setBackground(Color.decode("#F0DEB5"));
        Panel panel2 = new Panel(new FlowLayout());
        panel2.setBackground(Color.decode("#F0DEB5"));
        Panel panel4 = new Panel(new BorderLayout());
        panel4.setBackground(Color.decode("#F0DEB5"));
        
        slected= new JTextArea();
        slected.setEditable(false);
        slected.setLineWrap(true);
        slected.setPreferredSize(new Dimension(130, 130));
        
        Font textFont = new Font("Times New Roman", Font.PLAIN, 14);
        slected.setFont(textFont);
        Next= new JButton("Next");
        
        panel =new Panel(new FlowLayout(FlowLayout.RIGHT,30,20));
        movie1= new JRadioButton("up");
        movie1.setBackground(Color.decode("#F0DEB5"));
        
        movie2= new JRadioButton("harry potter");
        movie2.setBackground(Color.decode("#F0DEB5"));
        
        movie3= new JRadioButton("hush");
        movie3.setBackground(Color.decode("#F0DEB5"));
        
        movie1.setFont(new Font("Times New Roman",Font.BOLD,20));
        movie2.setFont(new Font("Times New Roman",Font.BOLD,20));
        movie3.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        Next.addActionListener(new lisListener());
        
        d3=new JLabel("Description of the film: ");
        d3.setFont(new Font("Times New Roman",Font.BOLD,17));
        
        d4=new JLabel("  AVAILABLE MOVIES :   ");
        d4.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        ButtonGroup m = new ButtonGroup();
        m.add(movie1);
        m.add(movie2);
        m.add(movie3);
        
        movie1.addActionListener(new lisListener());
        movie2.addActionListener(new lisListener());
        movie3.addActionListener(new lisListener());
        
        panel.add(Next);
        panel1.add(d4);
        d4.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        panel1.add(movie1);
        panel1. add(movie2);
        panel1. add(movie3);
        panel2.add(d3);
        panel2.add(slected);
        panel1.add(panel2);
        
        panel4.add(panel1,BorderLayout.CENTER);
        panel4.add(panel,BorderLayout.SOUTH);
        
        add(panel4,BorderLayout.CENTER);
        
        pack();
        setSize(400, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
        private class lisListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(movie1.isSelected()){
                String d1="78 year old Carl\nFredricksen travels\nto Paradise Falls in his\nhouse equipped with \nballoons, inadvertently\ntaking a young\nstowaway";
                slected.setText(d1);
                c="UP";
                
            }
            if(movie2.isSelected()){
                String d1="A lonely orphan\n discovers he is a\n wizard and enrolls\n at Hogwarts\n School of \nWitchcraft and\n Wizardry";
                slected.setText(d1);
                String name ="harry potter";
                c=name;
            }
            if(movie3.isSelected()){
                String d1="When a masked\n killer appears at\nthe window of a\n deaf writer living\n in the woods, she\n must fight for her\n life in silence";
                slected.setText(d1);
                c="hush";
            }
            if(e.getSource()==Next){
                if (!movie1.isSelected() && !movie2.isSelected() && !movie3.isSelected()) {
            showMessage("Please select the movie");   
        } else{
                writeToFile(c);
            TimeWindow timeWindow = new TimeWindow();
            timeWindow.setVisible(true);
            setVisible(false);
            dispose();
            }
            }
               
        
        }
         private void showMessage(String message) {
        // Display the message above the button
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.RED);
        panel.removeAll(); // Remove existing components in panel3
        panel.add(messageLabel); // Add the message label
        panel.add(Next); // Add the button
        panel.revalidate(); // Refresh the layout
    }
        }
        private void writeToFile(String c){
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ticket.dat",true))) {
            // Write to the binary file
            dos.writeUTF("Movie Name: "+c);
          
            dos.close();
                    
        } catch (IOException e) {
            
            e.printStackTrace(); 
        }  
    
    
}
}
        