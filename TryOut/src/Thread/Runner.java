/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

/**
 *
 * @author johan
 */
public class Runner implements Runnable {

    private String s;

    public Runner(String s) {
        this.s = s;
    }

    @Override
    public synchronized void run() {
        this.s = s + " run ";
        System.out.println(s);
    }

}
