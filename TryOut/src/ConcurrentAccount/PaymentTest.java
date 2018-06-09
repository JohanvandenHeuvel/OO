/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcurrentAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author johan
 */
public class PaymentTest {

    public static void main(String[] args) {
        Account alice = new Account(20140001, 100);
        Account bob = new Account(20140002, 100);

        ExecutorService executor = Executors.newCachedThreadPool();

        Payment paymentab = new Payment(alice, bob, 20);
        Payment paymentba = new Payment(bob, alice, 30);

        executor.execute(paymentab);
        executor.execute(paymentba);
        executor.shutdown();
    }
}
