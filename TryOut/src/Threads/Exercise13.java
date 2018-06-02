/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

/**
 *
 * @author johan
 */
public class Exercise13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runner r1 = new Runner("1");
        Runner r2 = new Runner("2");
        Runner r3 = new Runner("3");
        
        Thread t1 = new Thread(r1); 
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r3);
        
//        r1.run();
//        r1.run();
//        r3.run();
        
        t1.start();
        
        t2.start();
        t3.start();
    }
    
}
