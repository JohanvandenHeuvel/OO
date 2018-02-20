/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author johan
 */
public class TestStatic {
    static int i;
    static int j;

    public TestStatic(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    @Override
    public String toString(){
        return "" + i + " " + j;
    }

    
    
}
