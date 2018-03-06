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
public class Multiplication extends DoubleArgumentExpression {

    public Multiplication(Expression a, Expression b) {
        super(a, b);
    }

    @Override
    public String toString() {
        return super.a.toString() + "*" + super.b.toString();
    }

    @Override
    public Expression eval(Map store) {
        Expression a = super.a.eval(store);
        Expression b = super.b.eval(store);
        if(a.isConstant() && b.isConstant()){
            return new Constant(a.toConstant() * b.toConstant());
        }
        return new Multiplication(a, b);
    }
}
