/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.Map;

/**
 * An expression with a double value
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Constant extends ZeroArgumentExpression{
    private double value;

    public Constant(double value) {
        this.value = value;
    }
    
    public static Constant constant(double value){
        return new Constant(value);
    }
    
    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public Expression eval(Map store) {
        return this;
    }   
}
