/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10_2;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class WaterMelon extends Item{

    public WaterMelon() {
        price = 4.50;
    }    

    @Override
    double shippingCost() {
        return 6.75;
    }
    
}
