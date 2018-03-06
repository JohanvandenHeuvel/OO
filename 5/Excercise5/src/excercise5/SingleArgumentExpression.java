/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

/**
 *
 * @author johan
 */
public abstract class SingleArgumentExpression extends Expression {
    Expression a;

    public SingleArgumentExpression(Expression a) {
        this.a = a;
    }
}
