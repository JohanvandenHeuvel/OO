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

public class Spender implements Runnable{
    private Account account;
    private int limit;
    private Random rand;
    
    public Spender(Account account, int limit) {
        this.account = account;
        this.limit = limit;
        this.rand = new Random();
    }

    @Override
    public void run() {
        int total_withdrawn = 0;
        while(total_withdrawn < limit){
            //TODO make random withdrawel
            int amount_to_withdrawn = rand.nextInt(300) + 100;
            account.withdraw(amount_to_withdrawn);
            total_withdrawn += amount_to_withdrawn;
        }
        System.out.println("Withdrawn in total:" + total_withdrawn);
    }
    
    
}
