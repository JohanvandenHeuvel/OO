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
public class Square extends SingleArgumentExpression{
    
    public Square(Expression a) {
        super(a);
    }

    @Override
    public String toString() {
        return a.toString() + "^" + 2;
    }

    @Override
    public double eval(Map store) {
        return a.eval(store)*a.eval(store);
    }
}
