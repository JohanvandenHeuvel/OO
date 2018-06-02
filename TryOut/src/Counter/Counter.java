/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author s4770528
 */
public class Counter {
    private int counter = 0;
    private Lock myLock = new ReentrantLock();
    
    public void incr(){
        myLock.lock();
        counter++;
        myLock.unlock();
    }
    
    public int getCounter(){
        myLock.lock();
        int value = counter;
        myLock.unlock();
        return counter;
    }
}
