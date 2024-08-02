/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uj.amc;

import java.util.ArrayList;

/**
 *
 * @author aseel
 */
public class Reservation {
    
      
    //fields
    private String[] Seat;
    private int roomNo;
    private ArrayList<Integer> seatReserved;
    public final String PROMO_CODE = "Popcorn";
    private CustomerInfo customerInfo;//object field
    private MovieDetails movieDetails;//object field

    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    
    /**
     * Constructor
     */
    public Reservation() {

    }

    /**
     * Constructor
     * @param num The movie room Seats
     */

    public Reservation( String[] num) { //yes
        
        Seat = num;
    }

    
    /**
     * Constructor
     * @param info An CustomerInfo object
     * @param movie An MovieDetils object
     * @param stReserved The reserved seats
     * @param room The movie room number
     */
    public Reservation(CustomerInfo info, MovieDetails movie, ArrayList<Integer> stReserved, int room) {//yes
        movieDetails = movie;
        customerInfo = info;
        seatReserved = stReserved;
        roomNo = room;

    }

    //////////////////////////////////   //////////////////////////////////   ////////////////////////////////// 
    
    /**
     * set the screens list
     * @param screen An ArrayList of String containing the screens type
     */
    /*public void setScreen(ArrayList<String> screen) {
        Screens = screen;
    }*/

    /**
     * set the Seats array
     * @param num An Array of String containing the movie room seats
     */
    public void setSeat(String[] num) {
        Seat = num;
    }

    /**
     * set the CustomerInfo object
     * @param Info A CustomerInfo object containing the customer info
     */
    public void setCustomerInfo(CustomerInfo Info) {
        Info = new CustomerInfo();
    }

    /**
     * set the MovieDetails object
     * @param movie A MovieDetails object containing movie details
     */
    public void setMovieDetails(MovieDetails movie) {
        movie = new MovieDetails();
    }

    /**
     * set the movie room number
     * @param room An integer containing the movie room number
     */
    public void setRoomNo(int room) {
        roomNo = room;
    }

    /**
     * set the seats reserved by the customer
     * @param stReserved An ArrayList of integer containing the reserved seats
     */
    public void setSeatReserved(ArrayList<Integer> stReserved) {
        seatReserved = stReserved;
    }

    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    

    /**
     * get the Seats array
     * @return An Array of String representing the movie room seats
     */
    public String[] getSeat() {
        return Seat;
    }

    /**
     * get the CustomerInfo object
     * @return a copy of the customerInfo object
     */
    public CustomerInfo getCustomerInfo() {
        return new CustomerInfo(customerInfo);
    }

    /**
     * get the MovieDetails object
     * @return a copy of the movieDetails object
     */
    public MovieDetails getMovieDetails() {
        return new MovieDetails(movieDetails);
    }

    /**
     * get the movie room number
     * @return An integer representing the movie room number
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * get the seats reserved by the customer
     * @return An ArrayList of integer representing the reserved seats
     */
    public ArrayList<Integer> getSeatReserved() {
        return seatReserved;
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
 
    /**
     * this method calculates the total price with or without discount
     * @param selectedSeats An integer containing the number of seats reserved
     * @param TicketPrice An integer containing the price of the screen type reserved
     * @param custCode A String containing the discount code entered by the customer
     * @return An integer total price with or without discount 
     */
    public int TotalPriceWithDiscount(int selectedSeats, int TicketPrice, String custCode) {
        int totalPrice = TotalPrice(selectedSeats,TicketPrice);
        if (PromoApplied(custCode) == true) {
            totalPrice -= 10;
            System.out.println("Yay!!! YOU GOT A DISCOUNT\n");
        }
        else{
            System.out.println("WRONG CODE!! MAYBE NEXT TIME <3\n");
        }
        return totalPrice;
    }
    
    /**
     * this method calculates the total price
     * @param selectedSeats An integer containing the number of seats reserved
     * @param TicketPrice An integer containing the price of the screen type reserved
     * @return An integer total price
     */
    public int TotalPrice(int selectedSeats, int TicketPrice) {
        int totalPrice = selectedSeats * TicketPrice;
        return totalPrice;
    }
    
    /**
     * This method compares the valid discount code with the one entered by the customer
     * @param custCode A String containing the discount code entered by the customer
     * @return a boolean value
     */
    public boolean PromoApplied(String custCode) {
        return custCode.equals(PROMO_CODE);
    }

    
    
    /**
     * toString method to return the details
     */
    @Override
    public String toString() {

        return "" + customerInfo + movieDetails + "\nYour seat is: " + seatReserved + "\nYour room number is: " + roomNo + "A";

    }

      
    
}
