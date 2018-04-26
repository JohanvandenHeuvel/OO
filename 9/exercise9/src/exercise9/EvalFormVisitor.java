/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

import java.util.Map;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class EvalFormVisitor implements FormVisitor{
    private Map<String, Boolean> environ;

    public EvalFormVisitor(Map<String, Boolean> environ) {
        this.environ = environ;
    }

    @Override
    public Object visit(BinOpForm form) {
        return form.getOp().apply(
                (Boolean) form.getLeft().accept(this), 
                (Boolean) form.getRight().accept(this));
    }

    @Override
    public Object visit(NotForm form) {
        return ! (Boolean) form.getOperand().accept(this);
    }

    @Override
    public Object visit(AtomForm form) {
        return environ.get(form.getName());
    }

    @Override
    public Object visit(BasicForm form) {
        return form.value;
    }
}
