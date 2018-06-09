/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

/**
 *
 * @author johan
 */
public class Payment implements Runnable{
    private final Account from, to;
    private final int amount;

    public Payment(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
//        from.withdraw(amount);
//        to.deposit(amount);
    
        from.transfer(amount, to);

        System.out.println(from);
        System.out.println(to);
        System.out.println("");
    }
    
    
}
