/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

/**
 *
 * @author johan
 */
public class NotForm implements Form{

    private Form a;

    public NotForm(Form a) {
        this.a = a;
    }

    public Form getOperand() {
        return a;
    }

    public void accept(FormVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return  "not " + a.toString();
    }
    
    
}
