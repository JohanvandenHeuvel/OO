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
public class Creditcard implements PaymentMethod{
    private final String date; // expiration date
    private final int cardnumber;

    public Creditcard(String date, int cardnumber) {
        this.date = date;
        this.cardnumber = cardnumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with card %d which expires at %s\n", amount, cardnumber, date);
        return true;
    }
}
