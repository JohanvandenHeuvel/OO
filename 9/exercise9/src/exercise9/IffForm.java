/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

import java.util.function.BinaryOperator;

/**
 *
 * @author johan
 */
public class IffForm implements Form {

    private Form a,b;
    BinaryOperator<Boolean> operator = (a, b) -> a && b;
    
    public IffForm(Form a, Form b) {
        this.a = a;
        this.b= b;
    }

    public Form[] getOperands() {
        Form[] pair = {a,b};
        return pair;
    }

    public void accept(FormVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "if and only if " + a.toString() + " then " + b.toString();
    }
}
