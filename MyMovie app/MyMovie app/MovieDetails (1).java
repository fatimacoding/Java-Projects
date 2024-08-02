/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uj.amc;

/**
 *
 * @author aseel
 */
public class MovieDetails {
    
    //fields
    private String movieTime;
    private String movieName;
    private String movieAgeRating;
    
    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////

    /**
     * Constructor
     */
    public MovieDetails() { 

    }

    /**
     * The copy constructor initializes the object
     * as a copy of another MovieDetils object.
     * @param Object2 The object to copy
     */
    public MovieDetails(MovieDetails Object2) {
        movieTime = Object2.movieTime;
        movieName = Object2.movieName;
        movieAgeRating = Object2.movieAgeRating;
    }

    /**
     *
     * @param time
     * @param name
     * @param AgeRating
     */
    //public MovieDetils(String time, String name, String AgeRating) {
       // MovieTime = time;
       // movieName = name;
       // movieAgeRating = AgeRating;
    //}

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////

    /**
     * set the movie time
     * @param time A String containing the movie time
     */
    public void setMovieTime(String time) {
        movieTime = time;
    }

    /**
     * set the movie name
     * @param name A String containing the movie name
     */
    public void setMovieName(String name) {
        movieName = name;
    }

    /**
     * set the movie age rating
     * @param AgeRating A String containing the movie age rating
     */
    public void setMovieAgeRating(String AgeRating) {
        movieAgeRating = AgeRating;
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////

    /**
     * get the movie time
     * @return A String representing the movie time
     */
    public String getMovieTime() {
        return movieTime;
    }

    /**
     * get the movie name
     * @return A String representing the movie name
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * get the movie age rating
     * @return A String representing the movie age rating
     */
    public String getMovieAgeRating() {
        return movieAgeRating;
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    
    
    /**
     * toString method to print the details
     * @return 
     */
    @Override
    public String toString() {
        String Str = "     Movie Age Rating: " + movieAgeRating +"\nMOVIE: " + movieName + "      " +"TIME: " + movieTime;
        return Str;
    }
    
    
}
