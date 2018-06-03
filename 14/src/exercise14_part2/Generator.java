/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.Iterator;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Generator implements Runnable {
    private final Buffer buffer;
    private int limit;

    public Generator(Buffer buffer, int limit) {
        this.buffer = buffer;
        this.limit = limit;
    }

    @Override
    public void run() {
        try {
            for (int i = 2; i < limit; i++) {
                buffer.put(i);
            }
        } catch (Exception e) {
        }
    }
}
