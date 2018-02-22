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

    private final int ARRAYSIZE = 3;
    Geometric[] shapes = new Geometric[ARRAYSIZE];
    boolean[] indexFilled = new boolean[ARRAYSIZE];

    public void commands() {
        String[] userInput = GeometricView.queryInput();
        String command = userInput[0];
        
        switch (command) {
            case "quit":
                quit();
                break;
            case "show":
//                show();
                break;
            case "circle":
                createCircle(GeometricView.stringToDouble(userInput, 1));
                break;
            case "rectangle":
                createRectangle(GeometricView.stringToDouble(userInput, 1));
                break;
            case "move":
                move(GeometricView.stringToDouble(userInput, 1));
                break;
            case "remove":
                remove(GeometricView.stringToDouble(userInput, 1));
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
        shapes[emptyIndex] = new Circle(
                    userInput[0],
                    userInput[1],
                    userInput[2]);
        indexFilled[emptyIndex] = true;
    }
    
    public void createRectangle(double[] userInput) {
        int emptyIndex = emptyIndex();
        shapes[emptyIndex] = new Rectangle(
                    userInput[0],
                    userInput[1],
                    userInput[2],
                    userInput[3]);
        indexFilled[emptyIndex] = true;
    }

    public void move(double[] userInput) {
        this.shapes[(int)userInput[0]].move(
                userInput[1],
                userInput[2]);
    }

    public void remove(double[] userInput) {
        this.shapes[(int)userInput[0]] = null;
    }

    public void sort() {
        Arrays.sort(shapes);
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
        for (int i = 0; i < 10; i++) {
            if (!this.indexFilled[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String s = "";
        s = s.concat("\n" + "The group now contains:" + '\n');
        for (int i = 0; i < this.shapes.length; i++) {
            if(indexFilled[i]){
                s = s.concat("index:" + i + " " + this.shapes[i].toString() + '\n');
            }
        }
        return s;
    }
}
