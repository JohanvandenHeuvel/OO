/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buffer;

/**
 *
 * @author johan
 */
public class BufferWriter implements Runnable {

    private final Buffer myBuffer;
    private final int startValue, nrOfItems;

    public BufferWriter(int startValue, int nrOfItems, Buffer myBuffer) {
        this.startValue = startValue;
        this.nrOfItems = nrOfItems;
        this.myBuffer = myBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < nrOfItems; i++) {
            myBuffer.add(startValue + i);
        }
    }
}
