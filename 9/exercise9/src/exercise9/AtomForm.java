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
public class AtomForm implements Form{
    
    private boolean a;
    BinaryOperator<Operations> operator;
    
    public AtomForm(boolean a) {
        this.a = a;
    }

    public Form getOperand() {
        return this;
    }

    public void accept(FormVisitor v) {
        v.visit(this);
    }
    
    @Override
    public String toString() {
        return  a + "";
    }
     
}
