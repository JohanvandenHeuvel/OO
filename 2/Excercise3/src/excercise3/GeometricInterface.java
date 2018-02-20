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
public interface GeometricInterface {    
    public double getLeft();
    public double getRight();
    public double getTop();
    public double getBottom();
    public double getArea();
    public void move(double dx, double dy);
    public int compareTo(GeometricInterface shape);
}
