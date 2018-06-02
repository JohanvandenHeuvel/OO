/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author johan
 */
public class Buffer<E> {

    private final E[] bufferArray;
    private int writeIndex = 0;
    private int readIndex = 0;

    private Lock myLock = new ReentrantLock();

    public Buffer(int size) {
        this.bufferArray = (E[]) new Object[size];;
    }

    void put(E element) {
        myLock.lock();
        try {
            bufferArray[writeIndex++] = element;
        } finally {
            myLock.unlock();
        }
    }

    E get() {
        myLock.lock();
        try {
            return bufferArray[readIndex++];
        } finally {
            myLock.unlock();
        }
    }
    
    public boolean bufferFull(){
        return writeIndex == bufferArray.length;
    }
    
    public boolean bufferEmpty(){
        return writeIndex == 0;
    }

}
