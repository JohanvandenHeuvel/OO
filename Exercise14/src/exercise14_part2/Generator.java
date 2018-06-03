/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14_part2;

import java.util.Iterator;

/**
 *
 * @author johan
 */
public class Generator implements Iterator<Integer>{
    private int next = 2;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        //return current and then increment by 1
        return next++;
    }
    
}