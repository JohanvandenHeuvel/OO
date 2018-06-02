/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class Consumer<E> implements Runnable{
    Buffer buffer;
    E item;
    
    private Lock myLock = new ReentrantLock();
    private Condition emptyBuffer = myLock.newCondition();

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        myLock.lock();
        try {
            while(buffer.bufferEmpty()){
                emptyBuffer.await();
            }
            item = (E) buffer.get();
            System.out.println(item);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            myLock.unlock();
        }
    }
}
