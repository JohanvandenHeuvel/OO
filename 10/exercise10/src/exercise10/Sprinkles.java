/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Sprinkles extends Toppings{

    public Sprinkles(Ice ice) {
        super(ice);
    }

    @Override
    int price() {
        return super.price() + 0;
    }

    @Override
    public String giveDescription() {
        return ice.giveDescription() + " " + "with Sprinkles";
    }
    
    
    
}
