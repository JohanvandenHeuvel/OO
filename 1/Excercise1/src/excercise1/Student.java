/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

/**
 * Student class that contains the Name and the studentnumber for a student.
 * @author johan
 */
public class Student {
    private Name name;
    private int studentNumber;

    /**
     * Constuctor
     * @param name 
     * @param studentNumber 
     */
    public Student(Name name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    /**
     * Construtor
     * @param firstName
     * @param secondName
     * @param studentNumber 
     */
    public Student(String firstName, String secondName, int studentNumber) {
        this.name = new Name(firstName, secondName);
        this.studentNumber = studentNumber;
    }
    
    /**
     * 
     * @param name 
     */
    public void setName(Name name) {
        this.name = name;
    }
    
    /**
     * 
     * @param firstName
     * @param secondName 
     */
    public void setName(String firstName, String secondName) {
        this.name.setName(firstName, secondName);
    }
    
    /**
     * 
     * @return 
     */
    public Name getName() {
        return name;
    }
    
    /**
     * 
     * @return 
     */
    public int getStudentNumber(){
        return studentNumber;
    }
    
    /**
     * toString method returns a student name together with its number
     * @return 
     */
    @Override
    public String toString(){
        return name.toString() + ", s" + this.studentNumber;
    }
}
