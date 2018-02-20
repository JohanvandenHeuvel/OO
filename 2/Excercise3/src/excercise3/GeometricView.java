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

    public static String[] queryMove() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter what shape do you want to move, and how by how much for x and y respectivly, seperated by spaces");
        String s = reader.nextLine();
        return s.split(" ");
    }

    public static String[] queryRemove() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter what shape do you want to remove");
        String s = reader.nextLine();
        return s.split(" ");
    }

    public static String[] queryShape() {
        Scanner reader = new Scanner(System.in);
        System.out.println("What shape do you want? (rectangle/circle)");
        String s = reader.nextLine();
        if (s.equals("rectangle")) {
            s = s + " " + queryRectangle();
        }
        if (s.equals("circle")) {
            s = s + " " + queryCircle();
        }
        return s.split(" ");
    }

    public static double[] queryCircle() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter coordinates x and y, followed by radius, all seperated by a space");
        String s = reader.nextLine();
        return stringToDouble(s.split(" "));
    }

    public static double[] queryRectangle() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter coordinates x and y, followed by height and width, all seperated by a space");
        String s = reader.nextLine();
        return stringToDouble(s.split(" "));
    }
    
    private static double[] stringToDouble(String[] s){
        double[] d = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            d[i] = Double.parseDouble(s[i]);
        }
        return d;
    }
}
