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

    private Form operand;

    public NotForm(Form operand) {
        this.operand = operand;
    }

    public Form getOperand() {
        return operand;
    }

    @Override
    public <R> R accept(FormVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return  "not " + operand.toString();
    }
}
