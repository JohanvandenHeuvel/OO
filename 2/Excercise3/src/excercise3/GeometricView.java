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
public class GeometricView {

    public static void show(GeometricGroup group) {
        System.out.println(group);
    }
    
    public static String[] queryInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a command, followed by parameters");
        String s = reader.nextLine();
        return s.split(" ");
    }
}