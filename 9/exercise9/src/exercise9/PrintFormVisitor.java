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
public class PrintFormVisitor implements FormVisitor{

    @Override
    public Object visit(BinOpForm form) {
        return form.getLeft().accept(this) + form.getOp().string + form.getRight().accept(this);
    }

    @Override
    public Object visit(NotForm form) {
        return "not " + form.getOperand();
    }

    @Override
    public Object visit(AtomForm form) {
        return form.getName();
    }

    @Override
    public Object visit(BasicForm form) {
        return "" + form.value;
    }
}
