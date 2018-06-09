/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcurrentAccount;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author johan
 */
public class Account {

    private final int myAccountNumber;
    private int myBalance;

    private Lock myLock = new ReentrantLock();

    //Each lock works on its own
    private Lock secondLock = new ReentrantLock();

    public Account(int myAccountNumber, int myBalance) {
        this.myAccountNumber = myAccountNumber;
        this.myBalance = myBalance;
    }

    /**
     * We want a way for withdraw and deposit to be done in pairs
     *
     * @param amount
     * @param to
     */
//    public void transfer(int amount, Account to){
//        myLock.lock();
//        try {
//            System.out.println(String.format("before %d: %d\n", myAccountNumber, myBalance));
//            System.out.println("withdrawing");
//            withdraw(amount);
//            System.out.println("depositing");
//            to.deposit(amount);
//            System.out.println(String.format("after %d: %d\n", myAccountNumber, myBalance));
//            System.out.println(myAccountNumber + "  " + to.getMyAccountNumber());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            myLock.unlock();
//        }
//    }
    public void transfer(int amount, Account to) {
        Lock first, second;
        if(myAccountNumber < to.myAccountNumber){
            first = myLock; second = to.myLock; //how is private lock accessable
        } else {
            first = to.myLock; second = myLock;
        }
        first.lock();
        try {
            second.lock();
            try {
                System.out.println("before from " + this);
                System.out.println("before to " + to);
                System.out.println("withdrawing " + amount);
                withdraw(amount);
                System.out.println("depositing " + amount);
                to.deposit(amount);
                System.out.println("after from " + this);
                System.out.println("after to " + to);
                System.out.println("");
            } finally {
                second.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            first.unlock();
        }
    }

    public void deposit(int amount) {
        myLock.lock();
        try {
            myBalance += amount;
        } finally {
            myLock.unlock();
        }
    }

    public void withdraw(int amount) {
        myLock.lock();
        try {
            myBalance -= amount;
        } finally {
            myLock.unlock();
        }
    }

    @Override
    public String toString() {
        return String.format("current %d: %d", myAccountNumber, myBalance);
    }

    public int getMyAccountNumber() {
        return myAccountNumber;
    }

}
