/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author johan
 */
public class ChocolateDip extends Toppings{

    public ChocolateDip(Ice ice) {
        super(ice);
    }

    @Override
    int price() {
        return super.price() + 30;
    }

    @Override
    public String giveDescription() {
        return ice.giveDescription() + " " + "with Chocolate Dip";
    }
    
    
    
    
    
}
