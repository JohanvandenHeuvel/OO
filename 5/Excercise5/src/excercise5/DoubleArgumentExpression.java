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
public abstract class DoubleArgumentExpression extends Expression{
    Expression a;
    Expression b;
    
    public DoubleArgumentExpression(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }
}
