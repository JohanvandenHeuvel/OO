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
public interface FormVisitor<R> {

    R visit(BinOpForm form);
    R visit(NotForm form);
    R visit(AtomForm form);
    R visit(BasicForm form);
    
}
