/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

import static excercise1.Helper.queryName;
import static excercise1.Helper.queryNumber;

/**
 * A Class which is a array of Student. 
 * Student is a class consisting of a Name (first and second) and a 
 * studentnumber
 * @author johan
 */
public class Group {
    private Student[] students;

    /**
     * 
     * @param groupSize 
     */
    public Group(int groupSize) {
        this.students = new Student[groupSize];
    }
    
    /**
     * Loop through the array and fill every element
     */
    public void fillGroup(){
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student:" + (i + 1));
            System.out.println("New student:");
            students[i] = new Student(queryName(), queryNumber());
        }
    }
    
    /**
     * Update the Group. If a negative number is entered the loop ends. Otherwise
     * the Name of the entered student will be changed.
     */
    public void update(){
        int studentNumber = 0;
        do {        
            System.out.println("Student number:");
            studentNumber = queryNumber();
            if (studentNumber > 0) {
                for (Student student : students) {
                    if (student.getStudentNumber() == studentNumber) {
                        student.setName(queryName());
                    }
                }
                System.out.println(toString());
            }
        } while (studentNumber > 0);
        System.out.println("Program terminated");
    }
    
    @Override
    public String toString(){
        String s = "";
        s = s.concat("The group now contains:" + '\n');
        for (Student student : students) {
            s = s.concat(student.toString() + '\n');
        }
        return s;
    }
        
}
