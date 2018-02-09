/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import java.util.Scanner;

/**
 *
 * @author johan
 */
public class Helper {
    
    public static char queryUser(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a letter to make a guess:");
        String s = reader.next();
        return s.charAt(0);
    }
}
