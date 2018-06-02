/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drink;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author johan
 */
public class Simulation {

    public static final int NR_OF_GLASSES = 2, NR_OF_DRINKERS = 3;
    private Bar bar;
    private final Queue<Drinker> drinkers; //Line of drinkers

    public Simulation() {
        bar = new Bar(NR_OF_GLASSES);
        drinkers = new LinkedList<>();
    }

    public void simulate() {
        letDrinkersIn(NR_OF_DRINKERS);
        serveDrinkers();
    }

    /**
     * Add all the drinkers to the line
     *
     * @param nrOfDrinkers
     */
    private void letDrinkersIn(int nrOfDrinkers) {
        for (int i = 0; i < nrOfDrinkers; i++) {
            drinkers.offer(new Drinker(i, bar));
        }
    }

    /**
     * Serve a drink and if not satiesfied add to the line again
     */
    private void serveDrinkers() {
        /**
         * Normal version
         */
        while (!drinkers.isEmpty()) {
            Drinker drinker = drinkers.poll();
            drinker.tapAndDrink();
            if (!drinker.isSatisfied()) {
                drinkers.offer(drinker);
            }
        }

//        /**
//         * Concurrent version
//         */
//        for(Drinker drinker : drinkers){
//            new Thread(new DrinkRunner(drinker)).start();
//        }
    }

}
