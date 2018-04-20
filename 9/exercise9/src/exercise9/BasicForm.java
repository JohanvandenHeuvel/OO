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
public enum BasicForm implements Form {
    TRUE(true), FALSE(false);

    private BasicForm(boolean value) {
        this.value = value;
    }

    public final boolean value;

    @Override
    public <R> R accept(FormVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
