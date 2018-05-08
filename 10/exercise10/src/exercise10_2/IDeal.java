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
public class IDeal implements PaymentMethod{
    private final String bank;
    private int account, pin; //account and pin number

    public IDeal(String bank, int account, int pin) {
        this.bank = bank;
        this.account = account;
        this.pin = pin;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with account %d with pin %d from %s\n", amount, account, pin, bank);
        return true;
    }
}
