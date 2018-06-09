/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiningPhilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author johan
 */
public class DiningPhilosophers {

    private static final int NR_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Fork[] forks = new Fork[NR_PHILOSOPHERS];
        for (int i = 0; i < NR_PHILOSOPHERS; i++) {
            forks[i] = new Fork();
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < NR_PHILOSOPHERS; i++) {
            Philosopher ph = new Philosopher(forks[i], forks[(i + 1) % NR_PHILOSOPHERS], i);
            executor.execute(ph);
        }

        executor.shutdown();

    }

}
