/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.Map;

/**
 * Subclass of one expression, implements power of two
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Square extends SingleArgumentExpression{
    
    public Square(Expression a) {
        super(a);
    }
    
    public static Square square(Expression a){
        return new Square(a);
    }

    @Override
    public String toString() {
        String s = a.toString() + "^" + 2;
        return "(" + s + ")";
    }

    @Override
    public Expression eval(Map store) {
        Expression a = super.a.eval(store);
        if(a.isConstant()){
            return new Constant(a.toConstant()*a.toConstant());
        }
        return this;
    }
}
