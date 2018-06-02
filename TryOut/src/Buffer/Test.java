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
public class Test {

    private static final int BSIZE = 10;

    public static void main(String[] arg) {
        Buffer buffer = new Buffer(BSIZE);

        BufferWriter w1 = new BufferWriter(1, BSIZE / 2, buffer);
        BufferWriter w2 = new BufferWriter(14, BSIZE / 2, buffer);

        Thread wTread1 = new Thread(w1);
        Thread wTread2 = new Thread(w2);
        
        try {
            wTread1.start();
//            wTread1.join();
            wTread2.start();
            wTread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        w1.run();
//        w2.run();
        // need to make sure threads are finnished before printing the results
        System.out.println(buffer);
    }
}
