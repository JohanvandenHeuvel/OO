/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10_2;

/**
 *
 * @author johan
 */
public class WineGlass extends Item{

    public WineGlass() {
        price = 8.50;
    }
    
    

    @Override
    double shippingCost() {
        return 6.75;
    }
    
}
