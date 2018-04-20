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
public interface Form {

    void accept(FormVisitor visitor);

    @Override
    public String toString();
    
}
