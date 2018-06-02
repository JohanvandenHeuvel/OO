/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author johan
 */
public class Bar {
    private Tap tap;
    private List<Glass> glasses;
    
    private Lock myLock = new ReentrantLock();
    private Condition newGlass = myLock.newCondition();

    public Bar(int numberOfGlasses) {
        tap = new Tap();
        glasses = new ArrayList<>();
        for (int i = 0; i < numberOfGlasses; i++) {
            glasses.add(new Glass());
        }
    }
    
    public Glass drawBeer(Glass glass){
        return tap.fill(glass);
    }
    
    public boolean glassesLeft(){
        return glasses.size() > 0;
    }
    
    /**
     * Normal version
     * @return 
     */
    public Glass takeGlass(){
//        System.out.println("Take a glass");
        return glasses.remove(0);
    }
    
//    /**
//     * Concurrent version
//     * @return 
//     */
//    public Glass takeGlass(){
//        myLock.lock();
//        try {
//            while (glasses.isEmpty()) {                
//                newGlass.await();
//            }
//            return glasses.remove(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return null;
//        } finally{
//            myLock.unlock();
//        }
//    }
    
   /**
    * Normal version
    */
    public void putBack(Glass g){
//        System.out.println("PUt back a glass");
        glasses.add(g);
    }
    
//    /**
//     * Concurrent version
//     * @param g 
//     */
//    public void putBack(Glass g){
//        myLock.lock();
//        try {
//            glasses.add(g);
//            newGlass.signalAll();
//        } finally {
//            myLock.unlock();
//        }
//    }
    
}
