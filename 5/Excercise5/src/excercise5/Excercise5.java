/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author johan
 */
public class Excercise5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Double> store = new HashMap<>();
        store.put("pi", 3.1415);
        store.put("x", 42.);

        Variable v = new Variable("y");
        System.out.println(v);
        
        Constant d = new Constant(5);
        
        Constant c = new Constant(10);
        System.out.println(c);
        
        Addition a = new Addition(d, c);
        
        Multiplication ac = new Multiplication(a, v);
        System.out.println(ac);
        
        System.out.println(ac.eval(store));
    }
    
}
