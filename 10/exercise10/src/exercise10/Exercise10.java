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
public class Exercise10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO no ChocolateDip after WhippedCream
        // I do not know how to do this
        
        Ice ice = new VanillaIce();
        Ice ice2= new WhippedCream(ice);
        Ice ice3 = new ChocolateDip(ice2);
        System.out.println(ice.giveDescription());
        System.out.println(ice2.giveDescription());
        System.out.println(ice3.giveDescription());
        System.out.println(ice3.price());
    }
    
}
