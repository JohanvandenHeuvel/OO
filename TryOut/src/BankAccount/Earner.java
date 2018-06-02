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
import java.util.Random;

public class Earner implements Runnable{
    private Account account;
    private int limit;
    private Random rand;

    public Earner(Account account, int limit) {
        this.account = account;
        this.limit = limit;
        this.rand = new Random();
    }

    @Override
    public void run() {
        int total_deposit = 0;
        while(total_deposit < limit){
            //TODO make random withdrawel
            int amount_to_deposit = rand.nextInt(200) + 150;
            account.deposit(amount_to_deposit);
            total_deposit += amount_to_deposit;
        }
        System.out.println("Deposited in total:" + total_deposit);
    }
    
    
}
