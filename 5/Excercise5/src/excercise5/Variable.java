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
    public double eval(Map store) {
        //implement the hasb table like in the example
        return (double) store.get(name);
    }
}
