/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.Iterator;

/**
 *
 * @author johan
 */
public class Generator implements Runnable {
    private final Buffer buffer;

    public Generator(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 2; i < 100; i++) {
//                System.out.println("added: " + i);
                buffer.put(i);
                
            }
        } catch (Exception e) {
        }
    }
}
