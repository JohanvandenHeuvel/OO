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
public class WashingMachine extends Item{

    public WashingMachine() {
        price = 499;
    }

    @Override
    double shippingCost() {
        return 30;
    }
    
}
