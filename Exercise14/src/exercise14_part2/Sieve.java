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
public class Sieve implements Runnable{
    private int prime;
    private Buffer input;
    private Buffer output;

    public Sieve(int prime, Buffer input, Buffer output) {
        this.prime = prime;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length; i++) {
            int element = (int) input.get();
            if(element % prime != 0){
                output.put(element);
            }
        }
    }

    public Buffer getOutput() {
        return output;
    }
    
    

}
