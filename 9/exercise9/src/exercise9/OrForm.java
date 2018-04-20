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
public class OrForm implements Form {

    private Form a,b;

    public OrForm(Form a, Form b) {
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
        return a.toString() + " or " + b.toString();
    }
}
