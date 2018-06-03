/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part1;

/**
 *
 * @author johan
 */
public class Producer<E> implements Runnable{
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {        
        try {
            for (int i = 0; i < 100; i++) {
                buffer.put(i);
            }
        } catch (Exception e) {
        }
    }
    
}