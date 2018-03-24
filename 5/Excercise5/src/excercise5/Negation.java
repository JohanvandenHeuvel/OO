/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.Map;

/**
 * Subclass of one expression, implements negation
 * i.e. inversion of the sign.
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Negation extends SingleArgumentExpression{

    public Negation(Expression a) {
        super(a);
    }
    
    public static Negation neg(Expression a){
        return new Negation(a);
    }

    @Override
    public String toString() {
        String s = "-" + a.toString();
        return "(" + s + ")";
    }

    @Override
    public Expression eval(Map store) {
        Expression a = super.a.eval(store);
        if(a.isConstant()){
            return new Constant(-1.*a.toConstant());
        }
        return this;
    }
}
