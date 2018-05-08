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
public class Exercise10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Item i1 = new WashingMachine();
        Item i2 = new WineGlass();
        Item i3 = new WaterMelon();
        
        ShoppingCart s = new ShoppingCart();
        
        s.add(i1);
        s.changePaymentMethod(new PayPal("at@", "Tommy"));
        s.add(i2);
        s.changePaymentMethod(new Creditcard("never", 42));
        s.add(i3);
        
        
        System.out.println(s.totalPrice());
    }
    
}

