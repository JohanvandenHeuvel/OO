/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Buffer<E> {

    private final E[] bufferArray;
    private int writeIndex = 0;
    private int readIndex = 0;
    private int resets = 0; //went from end to begin

    private final Lock myLock;
    private final Condition bufferEmpty, bufferFull;

    public int length;

    public Buffer(int size) {
        this.bufferArray = (E[]) new Object[size];
        myLock = new ReentrantLock();
        bufferEmpty = myLock.newCondition();
        bufferFull = myLock.newCondition();
        length = bufferArray.length;
    }

    void put(E element) {
        myLock.lock();
        try {
            
            while (writeIndex == readIndex && resets != 0) {
                bufferFull.await();
            }
            
            if(resets > 0){
//                System.out.println(writeIndex%(resets*length));
            bufferArray[writeIndex%(resets*length)] = element;
            }
            else{
//                 System.out.println(writeIndex);
            bufferArray[writeIndex] = element;
            }
            
            writeIndex++;
            
            bufferEmpty.signalAll();
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

    E get() {
        myLock.lock();
        E result = null;
        try {
            while (readIndex >= writeIndex - 1) {
                bufferEmpty.await();
            }

            
            if(resets > 0){
//                System.out.println(readIndex%(resets*length));
            result = bufferArray[readIndex%(resets*length)];
            }
            else{
//                 System.out.println(readIndex);
            result = bufferArray[readIndex];
            }
            
            
            
            readIndex++;
            bufferFull.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            myLock.unlock();
        }
        return result;
    }

    public E[] getBufferArray() {
        return bufferArray;
    }
    
    
}
