/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class PrimeGenerator {
    List<Sieve> sieves = new ArrayList<>();
    
    
    public void run(){
        Buffer predecessor = new Buffer(1000);
        Buffer successor = new Buffer(1000);
        
        // puts number from 2 in the buffer
        new Thread(new Producer(predecessor)).start();
        
        // buffer containing the next prime number
        successor.put(2);
        
        sieves.add(new Sieve(predecessor, successor, (int) successor.get()));
    }
}
