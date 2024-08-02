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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class TimeWindow extends JFrame implements Serializable {

    private JPanel mainPanel;
    private JPanel headerPanel;
    private JList<String> timeList;
    private JTextField selectedTime;
    private JLabel label;
    private JLabel label2;
    private JButton nextButton;
    private  JPanel buttonPanel;

    // The time slots
    private String[] timeSlots = {
            "6:00 AM", "9:00 AM", "12:00 PM", "2:00 PM", "6:00 PM", "7:00 PM"
    };

    /**
     * Constructor
     */
    public TimeWindow() {
        // Set the title.
        setTitle("Available Times");
        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with BoxLayout
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,25,20));
        mainPanel.setBackground(Color.decode("#F0DEB5")); // Set the background color of the main panel
        
        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,60));
        headerPanel.setBackground(Color.decode("#F0DEB5"));

        // Create the list.
        timeList = new JList<>(timeSlots);
        timeList.setFixedCellHeight(31); // Set the height of each cell
        timeList.setVisibleRowCount(6); // Set the visible row count
        JScrollPane scrollPane = new JScrollPane(timeList); // Add the list to a scroll pane
        scrollPane.setPreferredSize(new Dimension(90,190)); // Set the preferred size of the scroll pane
        // Set the selection mode to single selection.
        timeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //select only a single item
        // Register the list selection listener.
        timeList.addListSelectionListener(new ListListener());
        timeList.setFont(new Font("Times New Roman", Font.BOLD, 15));
        // Add the list to the main panel.
        mainPanel.add(scrollPane);

        // Create a panel for "Selected Time:" label and selectedTime text field
        JPanel selectedTimePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        selectedTimePanel.setBackground(Color.decode("#F0DEB5"));

        // Create the label.
        label = new JLabel("Selected Time: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        selectedTimePanel.add(label);

        // Create the text field.
        selectedTime = new JTextField(10);
        // Make the text field uneditable.
        selectedTime.setEditable(false);
        selectedTime.setPreferredSize(new Dimension(150, 20)); // Set the preferred size of the text field
        selectedTimePanel.add(selectedTime);

        mainPanel.add(selectedTimePanel);

        label2 = new JLabel("AVAILABLE TIMES:");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        headerPanel.add(label2);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new lisListener());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        buttonPanel.setBackground(Color.decode("#F0DEB5"));
        buttonPanel.add(nextButton);
         
        // Set the layout manager of the content pane to BorderLayout
        setLayout(new BorderLayout());

        // Add the header panel to the content pane in the NORTH position
        add(headerPanel, BorderLayout.NORTH);
        // Add the main panel to the content pane in the CENTER position
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Pack and display the window.
        pack();
        setSize(400, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    

    /**
     * Private inner class that handles the event when the user selects an item from the list.
     */
    private class ListListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            // Get the selected time slot.
            String selection = timeList.getSelectedValue();
            // Put the selected time slot in the text field.
            selectedTime.setText(selection);
            
        }
    }
    private class lisListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nextButton) {
            String selectedTime = timeWindow();
            if (selectedTime != null && !selectedTime.isEmpty()) {
                writeToFile();
                screens Screens = new screens();
                Screens.setVisible(true);
                setVisible(false);
                dispose();
            } else {
                showMessage("Please select a time.");
            }
        }
        }
    }
        
    
    public String timeWindow(){
        String selection = timeList.getSelectedValue();
        return selection;
        
        
    }
    private void showMessage(String message) {
        // Display the message above the button
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.RED);
        buttonPanel.removeAll(); // Remove existing components in panel3
        buttonPanel.add(messageLabel); // Add the message label
        buttonPanel.add(nextButton); // Add the button
        buttonPanel.revalidate(); // Refresh the layout
    }
   private void writeToFile() {
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Ticket.dat",true))) {
            // Write to the binary file
            dos.writeUTF("Movie Time: "+selectedTime.getText());
              
            dos.close();
           
        } catch (IOException e) {
            
            e.printStackTrace(); 
        }
}
}