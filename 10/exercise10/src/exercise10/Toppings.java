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
public abstract class Toppings extends Ice{
    protected final Ice ice;

    public Toppings(Ice ice) {
        this.ice = ice;
    }

    @Override
    int price() {
        return ice.price();
    }
}
