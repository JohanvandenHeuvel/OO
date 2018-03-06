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
//        store.put("x", 42.);

        Variable v = new Variable("x");
        Constant two = new Constant(2.);
        Constant three = new Constant(3.);
        
        Multiplication m = new Multiplication(two, two);
        Addition a = new Addition(three, m);
        Multiplication result = new Multiplication(a, v);
        System.out.println(result);

    }
    
}
