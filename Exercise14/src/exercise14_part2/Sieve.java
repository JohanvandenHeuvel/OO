/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.Iterator;

/**
 *
 * @author johan
 */
public class Sieve implements Iterator<Integer>{
    private int prime;
    private Iterator<Integer> source;

    public Sieve(int prime, Iterator<Integer> source) {
        this.prime = prime;
        this.source = source;
    }
    
    

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int next = source.next();
        while (next % prime == 0) {            
            next = source.next();
        }
        return next;
    }
    

}
