/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

/**
 *
 * @author johan
 */
public class Sieve {

    Buffer predecessor;
    Buffer successor;

    int primeNumber;

    public Sieve(Buffer predecessor, Buffer successor, int primeNumber) {
        this.predecessor = predecessor;
        this.successor = successor;
        this.primeNumber = primeNumber;
    }

    /**
     * Copy elements that are not multiples of the prime number from the input
     * buffer to the output buffer
     */
    public void copy() {
        for (int i = 0; i < predecessor.length(); i++) {
            int element = (int) predecessor.get();
            if (element % primeNumber != 0) {
                successor.put(element);
            }
        }
    }

}
