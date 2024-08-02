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
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SeatsWindow extends JFrame implements Serializable {

    private final Set<Integer> bookedSeats;
    private final Set<Integer> selectedSeats;
    private final JTextField seatNumberTextField;
    private JButton nextButton;
    private JPanel nextButtonPanel ;
    double price;
    int seat;
    
    public SeatsWindow(double p) {
        bookedSeats = new HashSet<>();
        selectedSeats = new HashSet<>();
        price=p;
        
        setTitle("Available Seats");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        setSize(400, 650);     // Set the size of the window

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 5));

        // Create the seat buttons
        for (int seatNumber = 1; seatNumber <= 15; seatNumber++) {
            JButton seatButton = new JButton(String.valueOf(seatNumber));
            seatButton.setPreferredSize(new Dimension(50, 80)); // Set the preferred size of the button
            // Set the image icon for the button
            String imagePath = "newseats.png"; // Replace with your local file path
            ImageIcon icon = new ImageIcon(imagePath);
            seatButton.setIcon(icon);
            seatButton.setBackground(Color.decode("#F0DEB5"));

            seatButton.addActionListener(new SeatButtonListener(seatNumber));
            mainPanel.setBackground(Color.decode("#F0DEB5"));
            mainPanel.add(seatButton);
        }

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.decode("#F0DEB5"));
        centerPanel.add(mainPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Create the seat number text field
        seatNumberTextField = new JTextField(10);
        seatNumberTextField.setPreferredSize(new Dimension(0, 20)); // Set the preferred size of the text field

        // Create the Next button
        nextButton = new JButton("Next");
        
        JPanel selectedseatPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 60));
        selectedseatPanel.setBackground(Color.decode("#F0DEB5"));

        // Create the label.
        JLabel header = new JLabel("AVAILABLE SEATS:");
        header.setFont(new Font("Times New Roman", Font.BOLD, 20));
        selectedseatPanel.add(header);
        add(selectedseatPanel, BorderLayout.NORTH);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(Color.decode("#F0DEB5"));

        // Create the label panel
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 70));
        labelPanel.setBackground(Color.decode("#F0DEB5"));
        JLabel label = new JLabel ("Selected Seats:  ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        labelPanel.add(label);

        labelPanel.add(seatNumberTextField);

        // Create the next button panel
        nextButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        nextButtonPanel.setBackground(Color.decode("#F0DEB5"));
        nextButtonPanel.add(nextButton);
        nextButton.addActionListener(new lisListener());

        buttonPanel.add(labelPanel, BorderLayout.CENTER);
        buttonPanel.add(nextButtonPanel, BorderLayout.SOUTH);

        // Add the button panel to the window
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

        
    }

    private class SeatButtonListener implements ActionListener {
        private final int seatNumber;

        public SeatButtonListener(int seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            seat=0;
            if (bookedSeats.contains(seatNumber)) {
                
                // Custom code to handle seat already booked scenario
            } else if (selectedSeats.contains(seatNumber)) {
                selectedSeats.remove(seatNumber);
            } else {
                selectedSeats.add(seatNumber);
                seat+=1;
                
            }
            seatNumberTextField.setText(selectedSeats.toString());
            
        }
    }
    private class lisListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          if (e.getSource() == nextButton) {
                  if (selectedSeats.isEmpty()) {
                showMessage("Please select at least one seat.");
            } else {
                finalprice();
                PaymentWindow paymentWindow = new PaymentWindow();
                paymentWindow.setVisible(true);
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
        nextButtonPanel.removeAll(); // Remove existing components in panel3
        nextButtonPanel.add(messageLabel); // Add the message label
        nextButtonPanel.add(nextButton); // Add the button
        nextButtonPanel.revalidate(); // Refresh the layout
    }
    public void finalprice(){
        Random rooms = new Random();
        int roomNO = rooms.nextInt(10) + 1;
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ticket.dat",true))) {
            double finalpeice=selectedSeats.size()*price;
            dos.writeUTF("Cost: "+(int) finalpeice);
            dos.writeUTF("Number of Seats Booked: "+selectedSeats.size());
            dos.writeUTF("Your Seat is: "+selectedSeats);
            dos.writeUTF("Your Room Number is: "+roomNO+"A");
            dos.close();
            
        } catch (IOException e) {
            
           e.printStackTrace(); 
        }    
        
    }

}