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
public class Variable extends ZeroArgumentExpression{
    public String name;

    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public Expression eval(Map store) {
        if(store.containsKey(name)){
            return new Constant((double)store.get(name));
        }
        return this;
    }
}
