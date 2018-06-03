/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author johan
 */
public class Primes {

    List<Sieve> sieves = new ArrayList<>();

    private final Lock myLock;
    private final Condition bufferEmpty, bufferFull;

    public Primes() {
        this.myLock = new ReentrantLock();
        this.bufferEmpty = myLock.newCondition();
        this.bufferFull = myLock.newCondition();
    }

    public void run() {
        Buffer start = new Buffer(100);
        new Thread(new Generator(start)).start();

        // sieve for all even number
        sieves.add(new Sieve(2, start, new Buffer(100)));

        new Thread(sieves.get(sieves.size()-1)).start();

        // new sieve for every odd prime number
        while (true) {
            Buffer output = sieves.get(sieves.size()-1).getOutput();
            int prime = (int) output.get();
            System.out.println(prime);
            sieves.add(new Sieve(prime, output, new Buffer(100)));
            new Thread(sieves.get(sieves.size()-1)).start();
        }
    }
}
