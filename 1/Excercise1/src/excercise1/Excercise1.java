/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

import static excercise1.Helper.queryNumber;

/**
 * Excercise 1 for the course Object Orientation (2018)
 * The goal is the make a Student Class, which are grouped in a 
 * Group Class. 
 * @author Johan van den Heuvel
 * @author Niels Korporaal
 */
public class Excercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        
        System.out.print("Group size:");
        Group group = new Group(queryNumber());
        group.fillGroup();
        System.out.println(group);
        group.update();
    }
}
