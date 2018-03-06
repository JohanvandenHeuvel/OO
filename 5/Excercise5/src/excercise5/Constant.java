/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.Map;

/**
 *
 * @author johan
 */
public class Constant extends ZeroArgumentExpression{
    private double value;

    public Constant(double value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public double eval(Map store) {
        return value;
    }
}
