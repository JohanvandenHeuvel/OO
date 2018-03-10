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
public class Multiplication extends DoubleArgumentExpression {

    public Multiplication(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public String toString() {
        String s = super.a.toString() + "*" + super.b.toString();
        return "(" + s + ")";
    }

    @Override
    public Expression eval(Map store) {
        Expression a = super.a.eval(store);
        Expression b = super.b.eval(store);
        if (a.isConstant() && b.isConstant()) {
            return new Constant(a.toConstant() * b.toConstant());
        }
        if (a.isConstant() && a.toConstant() == 0.0
                || b.isConstant() && b.toConstant() == 0.0) {
            return new Constant(0.);
        }
        if (a.isConstant() && a.toConstant() == 1.0) {
            return b;
        }
        if (b.isConstant() && b.toConstant() == 1.0) {
            return a;
        }
        return new Multiplication(a, b);
    }
}
