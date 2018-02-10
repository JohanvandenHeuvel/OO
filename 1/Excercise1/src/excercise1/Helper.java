/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1;

import java.util.Scanner;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Helper {
    
    public static int queryNumber(){
        System.out.println("Enter a number");
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }
    
    public static Name queryName(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the first and second name, seperated by one space");
        String[] name = reader.nextLine().split(" ");
        return new Name(name[0], name[1]);
    }
    
    
}
