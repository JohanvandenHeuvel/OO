/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

import java.util.Scanner;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class IO {
    
    public static int queryInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("What line do you want to play?");
        return reader.nextInt();
    }
    
    public static void printBoard(Board b){
        System.out.println(b);
    }
    
    public static void printWinner(Player p){
        System.out.println("The winner is: " + p);
    }
}
