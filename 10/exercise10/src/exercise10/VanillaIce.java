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
public class VanillaIce extends Ice{

    public VanillaIce() {
        desription =  "Vanilla Ice";
    }
    
    @Override
    int price() {
        return 150;
    }
    
    @Override
    public String giveDescription() {
        return desription;
    }
    
}
