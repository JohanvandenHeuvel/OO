/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.Map;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public abstract class Expression {

    abstract public Expression eval(Map store);

    public boolean isConstant() {
        try {
            Double.parseDouble(this.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public double toConstant() {
        return (double) Double.parseDouble(this.toString());
    }
}
