/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Student {
    private Name name;
    private int studentNumber;

    public Student(Name name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public Student(String firstName, String secondName, int studentNumber) {
        this.name = new Name(firstName, secondName);
        this.studentNumber = studentNumber;
    }
    
    public void setName(Name name) {
        this.name = name;
    }
    
    public void setName(String firstName, String secondName) {
        this.name.setName(firstName, secondName);
    }
    
    public Name getName() {
        return name;
    }
    
    public int getStudentNumber(){
        return studentNumber;
    }
    
    @Override
    public String toString(){
        return name.toString() + ", s" + this.studentNumber;
    }
}
