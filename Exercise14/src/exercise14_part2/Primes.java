/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author johan
 */
public class Primes {
    List<Sieve> sieves = new ArrayList<>();
    
    public void run(){
        Iterator<Integer> source = new Generator();
        for (int i = 0; i < 100; i++) {
            int prime = source.next();
            source = new Sieve(prime, source);
            System.out.println(i + ": " + prime);
        }
    }
}
