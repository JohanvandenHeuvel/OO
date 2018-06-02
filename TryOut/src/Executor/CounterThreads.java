/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author s4770528
 */
public class CounterThreads {

    public static void main(String[] args) {
        Counter counter = new Counter();
        
        Incrementor incTask1 = new Incrementor(counter, 60);
        Incrementor incTask2 = new Incrementor(counter, 60);
        
        // create Executor service to manage threads
        ExecutorService executor = Executors.newCachedThreadPool();
        
        // start threads and place in runnable state
        executor.execute(incTask1);
        executor.execute(incTask2);
        
        // shut down worker threads when their tasks complete
        executor.shutdown();
    }
}
