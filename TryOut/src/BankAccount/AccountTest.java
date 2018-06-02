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
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000);
        
        Earner earner = new Earner(account, 5000);
        Spender spender = new Spender(account, 5000);
        
        Thread earnerThread = new Thread(earner);
        Thread spenderThread = new Thread(spender);
        
        earnerThread.start();
        spenderThread.start();
        
        try {
            earnerThread.join();
            spenderThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}
