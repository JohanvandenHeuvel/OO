/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise5;

import java.util.HashMap;
import java.util.Map;


import static excercise5.Addition.*;
import static excercise5.Multiplication.*;
import static excercise5.Constant.*;
import static excercise5.Variable.*;
import static excercise5.Negation.*;
import static excercise5.Square.*;


/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Excercise5 {

   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Double> store = new HashMap<>();
        store.put("pi", 3.1415);
//        store.put("x", 42.);

        Variable v = var("x");
        Constant two = constant(2.);
        Constant three = constant(3.);
        
        Multiplication m = mult(two, two);
        Addition a = add(three, m);
        Multiplication result = mult(a, v);
        System.out.println(result);

    }
    
}
