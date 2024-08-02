/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uj.amc;

/**
 *
 * @author aseel
 */
public class CustomerInfo {
   
      
    //fields
    private String name;
    private String phone;
    private int age;

    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    
    /**
     * Constructor
     */
    public CustomerInfo() {

    }

    /**
     * The copy constructor initializes the object
     * as a copy of another CustomerInfo object.
     * @param Object2 The object to copy
     */
    public CustomerInfo(CustomerInfo Object2) { //yes

        name = Object2.name;
        phone = Object2.phone;
        age = Object2.age;
    }

    /**
     * Constructor
     * @param name The customer name
     * @param phone The customer phone
     */
    public CustomerInfo(String name, String phone) {  //yes
        this.name = name;
        this.phone = phone;
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////

    /**
     * set the customer name
     * @param name A String containing the customer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the customer phone
     * @param phone A String containing the customer phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * set the customer age
     * @param age An integer containing the customer age
     */
    public void setAge(int age) {
        this.age = age;
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////

    /**
     * get the customer name
     * @return A String representing the customer name
     */
    public String getName() {
        return name;
    }

    /**
     * get the customer phone
     * @return A String representing the customer phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * get the customer age
     * @return An integer representing the customer age
     */
    public int getAge() {
        return age;
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    
    
    /**
     * toString method to return the details
     */
    @Override
    public String toString() {
        return "Name : " + name + "      " + " phone : " + phone+"\nAge: "+age+"   ";
    }

    
    
}
