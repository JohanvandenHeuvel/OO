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
public class Negation extends SingleArgumentExpression{

    public Negation(Expression a) {
        super(a);
    }

    @Override
    public String toString() {
        return "-" + a.toString();
    }

    @Override
    public Expression eval(Map store) {
        if(a.isConstant()){
            return new Constant(-1.0*a.toConstant());
        }
        return this;
    }
}
