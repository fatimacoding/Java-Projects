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
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextField;

/**
 *
 * @author 96656
 */
public class screens extends JFrame implements Serializable{

    private JRadioButton prime;
    private JRadioButton vip;
    private JRadioButton standard;
    private JTextField slected;
    private JLabel d1;
    private JLabel d4;
    private JButton Next;
    private String c;
    private Panel panel3;
    
    
    public screens(){
        setTitle("Screen Types");
        setSize(400,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout(30,40));
        Panel panel1 = new Panel(new FlowLayout(FlowLayout.CENTER,160,44));
        Panel panel2 = new Panel(new FlowLayout());
        panel3=new Panel(new FlowLayout(FlowLayout.RIGHT,30,20));
        Panel panel4 = new Panel(new BorderLayout());
        panel4.setBackground(Color.decode("#F0DEB5"));
        
        prime= new JRadioButton("Prime");
        prime.setFont(new Font("Times New Roman",Font.BOLD,20));
        prime.setBackground(Color.decode("#F0DEB5"));
        
        standard=new JRadioButton("Standard");
        standard.setFont(new Font("Times New Roman",Font.BOLD,20));
        standard.setBackground(Color.decode("#F0DEB5"));
        
        vip=new JRadioButton("VIP");
        vip.setFont(new Font("Times New Roman",Font.BOLD,20));
        vip.setBackground(Color.decode("#F0DEB5"));
        
        d1=new JLabel("Price:");
        d1.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        d4=new JLabel("  SCREEN TYPES: ");
        d4.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        slected= new JTextField(10);
        
        Next= new JButton("Next");
        Next.addActionListener(new lisListener());
        
        ButtonGroup m = new ButtonGroup();
        m.add(standard);
        m.add(prime);
        m.add(vip);
        
        prime.addActionListener(new lisListener());
        standard.addActionListener(new lisListener());
        vip.addActionListener(new lisListener());
        
        panel3.add(Next);
        panel1.add(d4);
        d4.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        panel1.add(vip);
        panel1.add(prime);
        panel1.add(standard);
        panel2.add(d1);
        panel2.add(slected);
        panel1.add(panel2);
        
        panel4.add(panel1,BorderLayout.CENTER);
        panel4.add(panel3,BorderLayout.SOUTH);
        add(panel4,BorderLayout.CENTER);
        
        pack();
        setSize(400, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
   private class lisListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean isRadioSelected = false;
             if(standard.isSelected()){
                String s="60";
                 slected.setText(s);
                 String screens="Standard";
                 c=screens;
                isRadioSelected = true;
            }
            if(prime.isSelected()){
                String s="100";
                 slected.setText(s);
                 String screens="Prime";
                 c=screens;
                 isRadioSelected = true;
            }
            if(vip.isSelected()){
                String s="150";
                 slected.setText(s);
                 String screens="VIP";
                 c=screens;
                 isRadioSelected = true;
            }
            if (e.getSource()==Next) {
                 if(isRadioSelected){
                    double s = screen();
                    writeToFile(c);
                    SeatsWindow seatsWindow = new SeatsWindow(s);
                    seatsWindow.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    showMessage("Please select a screen type.");
                }
        }
        }
          
        
        private void showMessage(String message) {
        // Display the message above the button
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.RED);
        panel3.removeAll(); // Remove existing components in panel3
        panel3.add(messageLabel); // Add the message label
        panel3.add(Next); // Add the button
        panel3.revalidate(); // Refresh the layout
    }
          
       public double screen(){
           double price=0.0;
           if(standard.isSelected()){
                 
                price+=60;
           }
           else 
               if(prime.isSelected()){
                
                price+=100;
           }
           else if(vip.isSelected()){
              
               price+=150;
           }
           
           return price;
       }
      
       
   }
   private void writeToFile(String c){
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ticket.dat",true))) {
         
            dos.writeUTF("Screen Type: "+c);
            
            dos.close();
                        
        } catch (IOException e) {
            
            e.printStackTrace();    
        }
                   
                
            }
}

