/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccount;

/**
 *
 * @author s4770528
 */
public class Account {
    private int balance; 

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    
    public void deposit(int amount){
        int old_balance = balance;
        balance = old_balance + amount;
    }
    
    public void withdraw(int amount){
        int old_balance = balance;
        balance = old_balance - amount;
    }
}
