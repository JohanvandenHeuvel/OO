/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drink;

/**
 *
 * @author johan
 */
public class DrinkRunner implements Runnable{
    private Drinker drinker;

    public DrinkRunner(Drinker drinker) {
        this.drinker = drinker;
    }

    @Override
    public void run() {
        while (! drinker.isSatisfied()) {            
            drinker.tapAndDrink();
        }
    }
    
    
}
