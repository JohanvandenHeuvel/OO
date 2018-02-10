/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

import static excercise1.Helper.queryName;
import static excercise1.Helper.queryNumber;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Group {
    private Student[] students;

    public Group(int groupSize) {
        this.students = new Student[groupSize];
    }
    
    /**
     * Loop through the array and fill every element
     */
    public void fillGroup(){
        System.out.println("--Filling--");
        for (int i = 0; i < students.length; i++) {
            System.out.println("\n" + "Student:" + (i + 1));
            System.out.println("New student:");
            students[i] = new Student(queryName(), queryNumber());
        }
    }
    
    /**
     * Update the Group. If a negative number is entered the loop ends. Otherwise
     * the Name of the entered student will be changed.
     */
    public void update(){
        System.out.println("--Updating--");
        int studentNumber;
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
        s = s.concat("\n" + "The group now contains:" + '\n');
        for (Student student : students) {
            s = s.concat(student.toString() + '\n');
        }
        return s;
    }
        
}
