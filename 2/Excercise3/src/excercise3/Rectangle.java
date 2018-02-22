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
public class Rectangle implements Geometric, Comparable<Geometric>{
    private double x;
    private double y;
    private double width;
    private double heigth;

    public Rectangle(double x, double y, double width, double heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }
    
    @Override
    public String toString(){
        String coordinates = "" + '(' + x + ',' + y + ')';
        return "coordinates:" + coordinates + " height:" + this.heigth + " width: " + this.width; 
    }

    @Override
    public double getLeft() {
        return x;
    }

    @Override
    public double getRight() {
        return x + width;
    }

    @Override
    public double getTop() {
        return y + heigth;
    }

    @Override
    public double getBottom() {
        return y;
    }

    @Override
    public double getArea() {
        return heigth * width;
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
    
    @Override
    public int compareTo(Geometric o){
        return Double.compare(this.getArea(), o.getArea());
    } 
}
