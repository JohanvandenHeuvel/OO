/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

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
    private final Buffer buffer;
    private final Lock myLock = new ReentrantLock();
    private final Condition fullBuffer = myLock.newCondition();
    
    private int i;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        myLock.lock();
        try {
            while (true) {                
                while(buffer.bufferFull()){
                fullBuffer.await();
            }
            buffer.put(i++);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            myLock.unlock();
        }
    }
    
}