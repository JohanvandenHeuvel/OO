/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise7;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Excercise7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree(input);

        Writer out = new StringWriter();
        qt.writeQTree(out);
        System.out.println(out.toString());

        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap(bitmap);
        System.out.println(bitmap);

        QTree qtB = new QTree(0, 0, bitmap.getWidth(), bitmap);
        Writer outB = new StringWriter();
        qtB.writeQTree(outB);
        System.out.println(outB.toString());
    }

}
