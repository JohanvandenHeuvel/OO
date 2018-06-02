/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counter;

/**
 *
 * @author s4770528
 */
public class CounterThreads {

    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Thread t1 = new Thread(new Incrementor(counter1, 50));
        Thread t2 = new Thread(new Incrementor(counter1, 50));
        Thread t3 = new Thread(new Incrementor(counter2, 100));
        Thread t4 = new Thread(new Incrementor(counter2, 100));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
