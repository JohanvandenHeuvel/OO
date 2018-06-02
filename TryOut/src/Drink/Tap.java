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
public class Tap {
    private static final int DRAW_TIME_PER_CC = 1;
    
    /**
     * Fill glass and drink it
     * @param glass
     * @return 
     */
    public Glass fill(Glass glass){
        glass.fill(glass.getAmount());
        takeABreak(glass.getAmount()* DRAW_TIME_PER_CC);
        return glass;
    }
    
    /**
     * Helper function to sleep
     * @param millisec 
     */
    public void takeABreak(int millisec){
        try{
            TimeUnit.MILLISECONDS.sleep(millisec);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
