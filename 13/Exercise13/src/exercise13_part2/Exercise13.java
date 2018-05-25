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
 *
 * @author johan
 */
public class Exercise13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Need to look at new Thread(this) and if the joins are correct. Also
         * look at the timing measures.
         */

        Exercise13 x = new Exercise13();
        x.testMergeSeq();
    }

    public void testMerge() {
        final int N = 10;
        final int size = 10;

        int[] array = IntStream.generate(() -> new Random().nextInt(N)).limit(size).toArray();

        for (int i : array) {
            System.out.println(i);
        }

        MergeSort.sort(array);

        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    public void testMergeSeq() {
        final int N = 10;
        final int size = 10;

        int[] array = IntStream.generate(() -> new Random().nextInt(N)).limit(size).toArray();

        for (int i : array) {
            System.out.println(i);
        }

        SortSeq ss = new SortSeq(array);

        try {
            Thread t = new Thread(ss);
            t.start();
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercise13.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

}
