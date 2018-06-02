/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class Exercise14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> integers = new ArrayList<>();
        
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        
        
       
        Buffer buffer = new Buffer(integers.size());
        
        // Should the iterators be inside the Runnable classes?
        integers.stream().forEach((integer) -> {
            new Thread(new Producer(buffer, integer)).start();
        });
        
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(buffer)).start();
        }
    }
}
