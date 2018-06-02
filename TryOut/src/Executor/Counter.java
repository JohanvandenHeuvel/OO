/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author s4770528
 */
public class Counter {
    private int counter = 0;
    
    public void incr(){
        counter++;
    }
    
    public int getCounter(){
        int value = counter;
        return counter;
    }
}
