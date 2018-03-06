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
public class Addition extends DoubleArgumentExpression {

    public Addition(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public String toString() {
        return a.toString() + "+" + b.toString();
    }

    @Override
    public double eval(Map store) {
        return a.eval(store) + b.eval(store);
    }
}
