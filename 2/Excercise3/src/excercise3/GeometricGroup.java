/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

import java.util.Arrays;

/**
 *
 * @author johan
 */
public class GeometricGroup {

    private final int ARRAYSIZE;
    Geometric[] shapes;

    public GeometricGroup(int arraysize) {
        this.ARRAYSIZE = arraysize;
        this.shapes = new Geometric[ARRAYSIZE];
    }

    public void commands() {
        String[] userInput = GeometricView.queryInput();
        String command = userInput[0];
        
        switch (command) {
            case "quit":
                quit();
                break;
            case "show":
                break;
            case "circle":
                createCircle(stringToDouble(userInput, 1));
                break;
            case "rectangle":
                createRectangle(stringToDouble(userInput, 1));
                break;
            case "move":
                move(stringToDouble(userInput, 1));
                break;
            case "remove":
                remove(stringToDouble(userInput, 1));
                break;
            case "sort":
                if(userInput.length > 1){
                    sort(userInput[1].charAt(0));
                }
                else{
                    sort();
                }
                break;
        }
        show();
    }

    public void quit() {
        System.exit(0);
    }

    public void show() {
        GeometricView.show(this);
    }
    
    public void createCircle(double[] userInput) {
        int emptyIndex = emptyIndex();
        if(emptyIndex >= 0){
            shapes[emptyIndex] = new Circle(
                    userInput[0],
                    userInput[1],
                    userInput[2]);
        }
    }
    
    public void createRectangle(double[] userInput) {
        int emptyIndex = emptyIndex();
        if(emptyIndex >= 0){
            shapes[emptyIndex] = new Rectangle(
                    userInput[0],
                    userInput[1],
                    userInput[2],
                    userInput[3]);
        }
    }

    public void move(double[] userInput) {
        int index = (int)userInput[0];
        if(index < ARRAYSIZE){
            this.shapes[index].move(
                userInput[1],
                userInput[2]);
        }
    }

    public void remove(double[] userInput) {
        int index = (int)userInput[0];
        if(index < ARRAYSIZE){
            this.shapes[index] = null;
        }
    }

    public void sort() {
        Arrays.sort(shapes, new GeometricCompare());
    }
    
    public void sort(char arg) {
        if (arg == 'x') {
            Arrays.sort(shapes, new GeometricCompareX());
        }
        if (arg == 'y') {
            Arrays.sort(shapes, new GeometricCompareY());
        }
    }

    private int emptyIndex() {
        for (int i = 0; i < ARRAYSIZE; i++) {
            if (this.shapes[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    private static double[] stringToDouble(String[] s, int from){
        double[] d = new double[s.length-from];
        for (int i = from; i < s.length; i++) {
            d[i-from] = Double.parseDouble(s[i]);
        }
        return d;
    }

    @Override
    public String toString() {
        String s = "";
        s = s.concat("\n" + "The group now contains:" + '\n');
        for (int i = 0; i < this.shapes.length; i++) {
            if(this.shapes[i] != null){
                s = s.concat("index:" + i + " " + this.shapes[i].toString() + '\n');
            }
        }
        return s;
    }
}
