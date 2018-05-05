/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Exercise9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
    
    public static void test1(){
        Map<String, Boolean> environ = new HashMap<>();
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
        Map<String, Boolean> environ = new HashMap<>();
        environ.put("a", false);
        environ.put("b", false);
        
        AtomForm a = new AtomForm("a");
        AtomForm b = new AtomForm("b");

        BinOpForm e = new BinOpForm(BinOp.IF, a,b);
        BinOpForm f = new BinOpForm(BinOp.OR, e, b);
        
        
        PrintFormVisitor print = new PrintFormVisitor();
        EvalFormVisitor eval = new EvalFormVisitor(environ);
        
        System.out.println(print.visit(f));
        
        System.out.println(eval.visit(f));
    }
    
    public static void test3(){
        Map<String, Boolean> environ = new HashMap<>();
        environ.put("a", true);
        environ.put("b", false);
        environ.put("c", true);
        
        AtomForm a = new AtomForm("a");
        AtomForm b = new AtomForm("b");
        AtomForm c = new AtomForm("c");

        BinOpForm e = new BinOpForm(BinOp.IF, a,b);
        BinOpForm f = new BinOpForm(BinOp.OR, e, b);
        BinOpForm g = new BinOpForm(BinOp.AND,f,c);
        
        
        PrintFormVisitor print = new PrintFormVisitor();
        EvalFormVisitor eval = new EvalFormVisitor(environ);
        
        System.out.println(print.visit(g));
        
        System.out.println(eval.visit(g));

    }
    
}
