/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

import java.util.HashMap;
import java.util.Map;
import javax.swing.plaf.basic.BasicFormattedTextFieldUI;

/**
 *
 * @author johan
 */
public class Exercise9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test1();
    }
    
    public static void test1(){
        Map<String, Boolean> environ = new HashMap<String, Boolean>();
        environ.put("a", false);
        environ.put("b", false);
        
        AtomForm a = new AtomForm("a");
        AtomForm b = new AtomForm("b");

        BinOpForm f = new BinOpForm(BinOp.OR, a, b);
        
        PrintFormVisitor print = new PrintFormVisitor();
        EvalFormVisitor eval = new EvalFormVisitor(environ);
        
        System.out.println(print.visit(f));
        
        System.out.println(eval.visit(f));
    }
    
    public static void test2(){

    }
    
    public static void test3(){

    }
    
}
