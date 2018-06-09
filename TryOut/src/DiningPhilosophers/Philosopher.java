/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiningPhilosophers;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author johan
 */
public class Philosopher implements Runnable {

    private Fork myLeftFork;
    private Fork myRightFork;
    private int myId;

    public Philosopher(Fork myLeftFork, Fork myRightFork, int myId) {
        this.myLeftFork = myLeftFork;
        this.myRightFork = myRightFork;
        this.myId = myId;
    }

    private void doAction(String action) {
        System.out.println("Philosopher " + myId + " " + action);
        takeABreak((int) (Math.random() * 100));
    }

    public void takeABreak(int millisec) {
        try {
            TimeUnit.MICROSECONDS.sleep(millisec);
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                doAction("Thinking");
                myLeftFork.pickUp();
                doAction("Picked up left fork");
                myRightFork.pickUp();
                doAction("Picked up right fork - now eating");
                myLeftFork.putDown();
                doAction("Put down left fork");
                myLeftFork.putDown();
                doAction("Put down right fork - back to thinking");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
