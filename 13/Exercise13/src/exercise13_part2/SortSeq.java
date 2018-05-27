/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise13_part2;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class SortSeq implements Runnable {

    int[] array;
    final int THRESHOLD = 10000001;

    public SortSeq(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int[] firstHalf = Arrays.copyOf(array, array.length / 2);
        int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

        if (array.length < THRESHOLD) {
            MergeSort.sort(firstHalf);
            MergeSort.sort(secondHalf);
            MergeSort.merge(firstHalf, secondHalf, array);
        } else {
            SortSeq sortLeft = new SortSeq(firstHalf);
            SortSeq sortRight = new SortSeq(secondHalf);
            MergeSeq mergeBoth = new MergeSeq(firstHalf, secondHalf, array);

            Thread left = new Thread(sortLeft);
            Thread right = new Thread(sortRight);
            Thread merge = new Thread(mergeBoth);
            
            left.run();
            right.run();

            try {
                left.join();
                right.join();
                merge.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(SortSeq.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
