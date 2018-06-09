/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiningPhilosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author johan
 */
public class Fork {

    private boolean pickedUp = false;
    private Lock myLock = new ReentrantLock();
    private Condition forkPutBack = myLock.newCondition();

    public void pickUp() throws InterruptedException {
        myLock.lock();
        try {
            while (pickedUp) {
                forkPutBack.await();
            }
            pickedUp = true;
        } finally {
            myLock.unlock();
        }
    }

    public void putDown() {
        myLock.lock();
        try {
            pickedUp = false;
            forkPutBack.signalAll();
        } finally {
            myLock.unlock();
        }
    }
}
