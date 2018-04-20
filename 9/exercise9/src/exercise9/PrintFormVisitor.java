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
    public void visit(Form form) {
        System.out.println(form.toString());
       
        
    }


    
}
