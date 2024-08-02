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
 
// Custom exception class for binary file operations
class BinaryFileException extends Exception {
    public BinaryFileException(String message) {
        super(message);
    }
}
