/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class BinOpForm implements Form{
    private BinOp op;
    private Form left;
    private Form right;

    public BinOpForm(BinOp op, Form left, Form right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public BinOp getOp() {
        return op;
    }

    public Form getLeft() {
        return left;
    }

    public Form getRight() {
        return right;
    }

    @Override
    public <R> R accept(FormVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
