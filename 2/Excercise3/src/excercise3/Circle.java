/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise3;

/**
 *
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Circle implements Geometric{
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
    public int compareTo(Geometric o){
        return Double.compare(this.getArea(), o.getArea());
    }    
}
