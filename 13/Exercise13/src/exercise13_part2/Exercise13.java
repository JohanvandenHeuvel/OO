/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise13_part2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Exercise13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exercise13 x = new Exercise13();
        x.testMerge();
        x.testMergeSeq();
        
    }

    public void testMerge() {
        long nanoTime = System.currentTimeMillis();
        final int N = 10;
        final int size = 10000000;

        int[] array = IntStream.generate(() -> new Random().nextInt(N)).limit(size).toArray();

        for (int i : array) {
            System.out.print(i + " ");
        }

        MergeSort.sort(array);
        
        System.out.println("");
        for (int i : array) {
            System.out.print(i + " ");
        }
        
        System.out.println("\n" + size + " pseudo-random integers");
        System.out.println(Runtime.getRuntime().availableProcessors() + " cores available");
        System.out.println((System.currentTimeMillis() - nanoTime) + "ms");
        
        /*
        * 10000 pseudo-random integers
        * 4 cores available
        * 313ms
        
        * 100000 pseudo-random integers
        * 4 cores available
        * 1094ms
        
        * 1000000 pseudo-random integers
        * 4 cores available
        * 8690ms
        
        * 10000000 pseudo-random integers
        * 4 cores available
        * 84825ms
        *
        */
    }

    public void testMergeSeq() {
        
        long nanoTime = System.currentTimeMillis();
        final int N = 10;
        final int size = 10000;

        int[] array = IntStream.generate(() -> new Random().nextInt(N)).limit(size).toArray();

        for (int i : array) {
            System.out.print(i + " ");
        }

        SortSeq ss = new SortSeq(array);

        try {
            Thread t = new Thread(ss);
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercise13.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("");
        
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n" + size + " pseudo-random integers");
        System.out.println(Runtime.getRuntime().availableProcessors() + " cores available");
        System.out.println((System.currentTimeMillis() - nanoTime) + "ms");
        
        /*
        * 10000 pseudo-random integers
        * 4 cores available
        * 297ms
        
        * 100000 pseudo-random integers
        * 4 cores available
        * 1188ms
        
        * 10000000 pseudo-random integers
        * 4 cores available
        * 90489ms
        */
    }
    
    

}
