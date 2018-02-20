/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

/**
 *
 * @author johan
 */
public class GeometricGroup {

    private final int ARRAYSIZE = 10;
    GeometricInterface[] shapes = new GeometricInterface[ARRAYSIZE];
    boolean[] indexFilled = new boolean[ARRAYSIZE];

    public void commands(String command) {
        switch (command) {
            case "quit":
                quit();
                break;
            case "show":
                show();
                break;
            case "circle":
                createCircle();
                break;
            case "rectangle":
                createRectangle();
                break;
            case "move":
                move();
                break;
            case "remove":
                remove();
                break;
            case "sort":
                sort();
                break;
        }
    }

    public void quit() {
        System.exit(0);
    }

    public void show() {
        GeometricView.show(this);
    }
    
    public void createCircle() {
        double[] userInput = GeometricView.queryCircle();
        int emptyIndex = emptyIndex();
        shapes[emptyIndex] = new Circle(
                    userInput[0],
                    userInput[1],
                    userInput[2]);
        indexFilled[emptyIndex] = true;
    }
    
    public void createRectangle() {
        double[] userInput = GeometricView.queryRectangle();
        int emptyIndex = emptyIndex();
        shapes[emptyIndex] = new Rectangle(
                    userInput[0],
                    userInput[1],
                    userInput[2],
                    userInput[3]);
        indexFilled[emptyIndex] = true;
    }

    public void move() {
        String[] userInput = GeometricView.queryMove();
        this.shapes[Integer.parseInt(userInput[0])].move(
                Double.parseDouble(userInput[1]),
                Double.parseDouble(userInput[2]));
    }

    public void remove() {
        String[] userInput = GeometricView.queryRemove();
        this.shapes[Integer.parseInt(userInput[0])] = null;
    }

    public void sort() {
        
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
                s = "Shape " + i + " " + s.concat(this.shapes[i].toString() + '\n');
            }
        }
        return s;
    }
}
