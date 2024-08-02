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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class PaymentWindow extends JFrame implements Serializable {
    private JLabel paymentLabel;
    private JComboBox<String> paymentComboBox;
    private JLabel cardNumberLabel;
    private JTextField cardNumberField;
    private JLabel cardPasswordLabel;
    private JPasswordField cardPasswordField;
    private JLabel applePayLabel;
    private JTextField applePayField;
    private JButton doneButton;
    private  JPanel northPanel ;
    private JPanel finishButtonPanel ;

    public PaymentWindow() {
        setTitle("Payment Method");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the north section
        northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,60));
        northPanel.setBackground(Color.decode("#F0DEB5"));
        
        paymentLabel = new JLabel("PAYMENT METHOD:");
        paymentLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        northPanel.add(paymentLabel);
        
        add(northPanel, BorderLayout.NORTH);

        // Create panel for the center section
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        // Create GridBagConstraints for center alignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);//top, left, bottom, right

        paymentComboBox = new JComboBox<>(new String[]{"Card", "Apple Pay", "Cash"});
        paymentComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));

        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cardNumberField = new JTextField();

        cardPasswordLabel = new JLabel("Card Password:");
        cardPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cardPasswordField = new JPasswordField();

        applePayLabel = new JLabel("Apple Pay Number:");
        applePayLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        applePayField = new JTextField();

        doneButton = new JButton("Done");
        doneButton.setFont(new Font("Times New Roman", Font.BOLD, 15));

        // Set size for text fields
        Dimension textFieldSize = new Dimension(200, 25);
        cardNumberField.setPreferredSize(textFieldSize);
        cardPasswordField.setPreferredSize(textFieldSize);
        applePayField.setPreferredSize(textFieldSize);

        // Add components to the center panel using GridBagConstraints
        gbc.insets = new Insets(10, 0, 5, 0); // Reset insets for paymentComboBox
        centerPanel.add(paymentComboBox, gbc);

        gbc.gridy = 1;
        centerPanel.add(cardNumberLabel, gbc);

        gbc.gridy = 2;
        centerPanel.add(cardNumberField, gbc);

        gbc.gridy = 3;
        centerPanel.add(cardPasswordLabel, gbc);

        gbc.gridy = 4;
        centerPanel.add(cardPasswordField, gbc);

        gbc.gridy = 5;
        centerPanel.add(applePayLabel, gbc);

        gbc.gridy = 6;
        gbc.insets = new Insets(5, 5, 130, 5);
        centerPanel.add(applePayField, gbc);

        gbc.gridy = 7;
        gbc.insets = new Insets(0, 250, 15, 0); // Add space at the bottom and right
        
        finishButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        finishButtonPanel.setBackground(Color.decode("#F0DEB5"));
        finishButtonPanel.add(doneButton);
        
        centerPanel.setBackground(Color.decode("#F0DEB5"));
        add(centerPanel, BorderLayout.CENTER);
        add(finishButtonPanel,BorderLayout.SOUTH);
        
        paymentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPayment = (String) paymentComboBox.getSelectedItem();
                if (selectedPayment.equals("Card")) {
                    cardNumberLabel.setEnabled(true);
                    cardNumberField.setEnabled(true);
                    cardPasswordLabel.setEnabled(true);
                    cardPasswordField.setEnabled(true);
                    applePayLabel.setEnabled(false);
                    applePayField.setEnabled(false);
                } else if (selectedPayment.equals("Apple Pay")) {
                    cardNumberLabel.setEnabled(false);
                    cardNumberField.setEnabled(false);
                    cardPasswordLabel.setEnabled(false);
                    cardPasswordField.setEnabled(false);
                    applePayLabel.setEnabled(true);
                    applePayField.setEnabled(true);
                } else {
                    cardNumberLabel.setEnabled(false);
                    cardNumberField.setEnabled(false);
                    cardPasswordLabel.setEnabled(false);
                    cardPasswordField.setEnabled(false);
                    applePayLabel.setEnabled(false);
                    applePayField.setEnabled(false);
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        String selectedPayment = (String) paymentComboBox.getSelectedItem();
        if (selectedPayment == null || selectedPayment.isEmpty()) {
            showMessage("Please select a payment method.");
            return;
        }

        if (selectedPayment.equals("Card")) {
            String cardNumber = cardNumberField.getText();
            String cardPassword = new String(cardPasswordField.getPassword());
            if (cardNumber.isEmpty() || cardPassword.isEmpty()) {
                showMessage("Please fill in all card details.");
                return;
            }
            
        } else if (selectedPayment.equals("Apple Pay")) {
            String applePayNumber = applePayField.getText();
            if (applePayNumber.isEmpty()) {
                showMessage("Please fill in the Apple Pay details.");
                return;
            }
            
        }

        // Proceed to the next step
        if (e.getSource() == doneButton) {
            writeToFile();
            try {
                readFromFile();
            } catch (BinaryFileException ex) {
               
            }
            
            setVisible(false);
            dispose();
        }
    }
});
   
        // Set background color for all components
        getContentPane().setBackground(Color.decode("#F0DEB5"));
        
        setSize(400, 650);
        setLocationRelativeTo(null); // Center the form on the screen
        setVisible(true);
    }
       

    private void showMessage(String message) {
        // Display the message above the button
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.RED);
        finishButtonPanel.removeAll(); // Remove existing components in panel3
        finishButtonPanel.add(messageLabel); // Add the message label
        finishButtonPanel.add(doneButton); // Add the button
        finishButtonPanel.revalidate(); // Refresh the layout
    }
    
    private void writeToFile() {
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ticket.dat",true))) {
            // Write to the binary file
            dos.writeUTF("Pay By: "+(String) paymentComboBox.getSelectedItem());
            
            dos.close();
                      
        } catch (IOException e) {
            
            e.printStackTrace(); 
        }
}
       
    private void readFromFile() throws BinaryFileException {
   
     ArrayList<String> ticket = new ArrayList<>();
    try (DataInputStream inputStream = new DataInputStream(new FileInputStream("Ticket.dat"))) {

        while (inputStream.available() > 0) {
            String data = (String) inputStream.readUTF();
            ticket.add(data);
        }

    } catch (IOException e) {
        throw new BinaryFileException("Error reading from binary file: " + e.getMessage());
    }
     String message = String.join("<br>", ticket);

        // Use HTML formatting to set the background color
        String htmlMessage = "<html><body style='background-color: darkgray; color: red; font-family: Times New Roman, sans-serif; font-size: 13px;'>" + message + "</body></html>";

        // Create a JLabel with HTML-formatted text
        JLabel label = new JLabel(htmlMessage);

    JOptionPane.showMessageDialog(null,label,"Ticket",JOptionPane.PLAIN_MESSAGE);
    
    
    }
}