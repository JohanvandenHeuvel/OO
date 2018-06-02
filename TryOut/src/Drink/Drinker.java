/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drink;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author johan
 */
public class Drinker {

    private int nrOfGlasses;
    private Bar bar;
    private static final int DRINKTIME_PER_CC = 5;

    public Drinker(int nrOfGlasses, Bar bar) {
        this.nrOfGlasses = nrOfGlasses;
        this.bar = bar;
    }

    /**
     * Normal version
     * Tap a drink for the drinker and drink it empty again
     */
    public void tapAndDrink() {
        if (bar.glassesLeft()) {
            Glass glass = bar.takeGlass();
            glass = bar.drawBeer(glass);
            takeABreak(glass.getAmount() * DRINKTIME_PER_CC);
            glass.empty();
            nrOfGlasses--;
            bar.putBack(glass);
        }
    }
    
//    /**
//     * Concurrent version Tap a drink for the drinker and drink it empty again
//     */
//    public void tapAndDrink() {
//        Glass glass = bar.takeGlass();
//        glass = bar.drawBeer(glass);
//        takeABreak(glass.getAmount() * DRINKTIME_PER_CC);
//        glass.empty();
//        nrOfGlasses--;
//        bar.putBack(glass);
//    }

    /**
     * The drinker is satisfied if he does not have any glasses
     *
     * @return
     */
    public boolean isSatisfied() {
        return nrOfGlasses <= 0;
    }

    public void takeABreak(int millisec) {
        try {
            TimeUnit.MILLISECONDS.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getNrOfGlasses() {
        return nrOfGlasses;
    }
    
    
}
