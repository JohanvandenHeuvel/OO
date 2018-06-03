/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Buffer<E> {

    private final E[] bufferArray;
    private int position = 0;

    private final Lock myLock;
    private final Condition bufferEmpty, bufferFull;

    public Buffer(int size) {
        this.bufferArray = (E[]) new Object[size];
        myLock = new ReentrantLock();
        bufferEmpty = myLock.newCondition();
        bufferFull = myLock.newCondition();
    }

    void put(E element) {
        myLock.lock();
        try {
            while (position == bufferArray.length-1) {
                bufferFull.await();
            }
            bufferArray[++position] = element;
            bufferEmpty.signalAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            myLock.unlock();
        }
    }

    E get() {
        myLock.lock();
        E result = null;
        try {
            while (position == 0) {
                bufferEmpty.await();
            }
            bufferFull.signalAll();
            result = bufferArray[position--];
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            myLock.unlock();
        }
        return result;
    }
}
