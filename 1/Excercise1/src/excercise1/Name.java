/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

import java.util.Scanner;

/**
 * Class consiting of a fist and second name of someone
 * @author johan
 */
public class Name {
    private String firstName;
    private String secondName;

    /**
     * Constructor
     * @param firstName
     * @param secondName 
     */
    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    /**
     *
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @param secondName 
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    /**
     * 
     * @param firstName
     * @param secondName 
     */
    public void setName(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    
    /**
     * returns first and second name as a String
     * @return 
     */
    @Override
    public String toString(){
        return this.firstName + " " + this.secondName;
    }
    
    
}
