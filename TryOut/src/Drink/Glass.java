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
public class Glass {
    private int amount = 0;
    
    public Glass(){
        this.amount = 0;
    }
    
    public void fill(int ccBeer){
        this.amount = ccBeer;
    }
    
    public void empty(){
        amount = 0;
    }

    public int getAmount() {
        return amount;
    }
}
