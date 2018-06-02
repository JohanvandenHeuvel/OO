/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executor;

/**
 *
 * @author s4770528
 */
public class Incrementor implements Runnable{
    private Counter myCounter;
    private int myLimit;

    public Incrementor(Counter myCounter, int myLimit) {
        this.myCounter = myCounter;
        this.myLimit = myLimit;
    }
    
    public void run(){
        for (int i = 0; i < myLimit; i++) {
            myCounter.incr();
        }
        System.out.println("Counter: " + myCounter.getCounter());
    }
}
