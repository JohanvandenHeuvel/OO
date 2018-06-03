/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Primes {

    List<Sieve> sieves = new ArrayList<>();

    private final int N = 100000; //How many iterations
    private final int BUFFERSIZE = 100;

    public void run() {
        Buffer start = new Buffer(N);
        new Thread(new Generator(start, N)).start();

        // sieve for all even number
        sieves.add(new Sieve(2, start, new Buffer(N)));

        new Thread(sieves.get(sieves.size()-1)).start();

        // new sieve for every odd prime number
        int i = 1;
        while (true) {
            Buffer output = sieves.get(sieves.size()-1).getOutput();
            int prime = (int) output.get();
            System.out.println(++i + ": " + prime);
            sieves.add(new Sieve(prime, output, new Buffer(N)));
            new Thread(sieves.get(sieves.size()-1)).start();
        }
    }
}
