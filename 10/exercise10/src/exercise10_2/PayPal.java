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
public class PayPal implements PaymentMethod{
    private String email, password;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with paypal for %s, password %s\n", amount, email, password);
        return true;
    }
}
