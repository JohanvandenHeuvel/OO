/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buffer;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author johan
 */
public class Buffer {
    private final int[] bufferArray;
    private int writeIndex = 0;
    
    public static final int PAUSE = 50;
    
    public Buffer(int size){
        bufferArray = new int[size];
    }
    
    public void add(int value){
        int position = writeIndex;
        
        takeABreak((int)(Math.random() * PAUSE));
        
        bufferArray[position] = value;
        
        takeABreak((int)(Math.random() * PAUSE));
        
        writeIndex++;
        
    }
    
    public void takeABreak(int millisec){
        try {
            TimeUnit.MICROSECONDS.sleep(millisec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        for (int i : bufferArray) {
            System.out.println(i);
        }
        return "done";
    }
    
    
}
