/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

import java.util.Scanner;

/**
 *
 * @author johan
 */
public class Excercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeometricGroup gg = new GeometricGroup();
        while (true) {  
            run(gg);
        }
    }
    
    public static void run(GeometricGroup gg){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a command");
        gg.commands(reader.nextLine());
    }
    
}  
