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
public class Producer<E> implements Runnable{
    private Buffer buffer;
    private E item;
    
    private Lock myLock = new ReentrantLock();
    private Condition fullBuffer = myLock.newCondition();

    public Producer(Buffer buffer, E item) {
        this.buffer = buffer;
        this.item = item;
    }

    @Override
    public void run() {
        myLock.lock();
        try {
            while(buffer.bufferFull()){
                fullBuffer.await();
            }
            buffer.put(item);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            myLock.unlock();
        }
    }
    
}
