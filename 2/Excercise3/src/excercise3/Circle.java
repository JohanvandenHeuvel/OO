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
public class Circle implements GeometricInterface{
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public String toString(){
        String coordinates = "" + '(' + x + ',' + y + ')';
        return "centre:" + coordinates + " radius:" + this.radius;
    }

    @Override
    public double getLeft() {
        return x-radius; 
    }

    @Override
    public double getRight() {
        return x+radius;
    }

    @Override
    public double getTop() {
        return y+radius;
    }

    @Override
    public double getBottom() {
        return y-radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
    
    @Override
    public int compareTo(GeometricInterface circle){
        double difference = this.getArea() - circle.getArea();
        
        if(difference < 0){return -1;}
        else if(difference > 0){return 1;}
        
        return 0;
    }
    
}
