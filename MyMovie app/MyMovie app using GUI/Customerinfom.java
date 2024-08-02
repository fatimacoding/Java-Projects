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
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author 96656
 */
 
    public class Customerinfom extends JFrame implements Serializable {
    private JTextField  f1;
    private JTextField f2;
    private JTextField f3;
    private JLabel name;
    private JLabel phone;
    private JLabel age;
    private JLabel d4;
    private String namecust ;
    private String phonec ;
    private String agen ;
    private JButton Next;
    private Panel panel3;
    
    public Customerinfom(){
        setTitle("Customer Informations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        Panel panel1 = new Panel(new FlowLayout(FlowLayout.CENTER,60,25));
        panel3=new Panel(new FlowLayout(FlowLayout.RIGHT,30,20));
        Panel panel4 = new Panel(new BorderLayout());
        panel4.setBackground(Color.decode("#F0DEB5"));
        
        f1= new JTextField(15); 
        f1.setPreferredSize(new Dimension(9, 20));
        
        f2= new JTextField(15);
        f2.setPreferredSize(new Dimension(9, 20));
        
        f3= new JTextField(15);
        f3.setPreferredSize(new Dimension(9, 20));
        
        Next= new JButton("Next");
                
        name=new JLabel("  Enter Your Name:");
        name.setFont(new Font("Times New Roman", Font.BOLD, 17));
        
        phone=new JLabel(" Enter Your Phone Number:");
        phone.setFont(new Font("Times New Roman", Font.BOLD, 17));
        
        age=new JLabel(" Enter Your Age:");
        age.setFont(new Font("Times New Roman", Font.BOLD, 17));
        
        d4=new JLabel("  CUSTOMER INFORMATIONS: ");
        d4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        Next.addActionListener(new lisListener());
        
        panel1.add(d4);
        d4.setBorder(BorderFactory.createEmptyBorder(40, 0, 50, 0)); // Add empty border
        panel1.add(name);
        panel1.add(f1);
        panel1.add(phone);
        panel1.add(f2);
        panel1.add(age);
        panel1. add(f3);
        panel3.add(Next);
      
        panel4.add(panel1,BorderLayout.CENTER);
        panel4. add(panel3,BorderLayout.SOUTH);
        add(panel4,BorderLayout.CENTER);
        
        pack();
        setSize(400, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
     private class lisListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             
            if(e.getSource()==Next){
            namecust=f1.getText();
            phonec=f2.getText();
            agen=f3.getText();
            if (namecust.isEmpty()||phonec.isEmpty() || agen.isEmpty()) {
             showMessage("Please enter information in all fields.");
             
            }
            else {
                writeToFile();
           Moviename moviename = new Moviename();
          moviename.setVisible(true);
            setVisible(false);
            dispose();
            
        }
        
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
        private void writeToFile() {
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ticket.dat"))) {
            // Write to the binary file
            
            dos.writeUTF("TICKET");
            dos.writeUTF("=============================");
            dos.writeUTF("Name: "+f1.getText());
            dos.writeUTF("Phone Number: "+f2.getText());
            dos.writeUTF("Age: "+f3.getText());
             
            dos.close();
            
        } catch (IOException e) {
            
            e.printStackTrace(); 
        }
               
            }
    
     }
    
