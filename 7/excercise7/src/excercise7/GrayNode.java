/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise7;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A grey node consists of four childnodes, each of which wrapped by QTree
 *
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GrayNode implements QTNode {

    QTree[] children = new QTree[4];

    public GrayNode(Reader input) {
        for (int i = 0; i < 4; i++) {
            children[i] = new QTree(input);
        }
    }

    public GrayNode(int x, int y, int width, Bitmap bitmap) {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                /**
                 * The order of nodes is: 1 2 3 4
                 */
                case 0:
                    children[i] = new QTree(x, y, width / 2, bitmap);
                    break;
                case 3:
                    children[i] = new QTree(x, y + width / 2, width / 2, bitmap);
                    break;
                case 1:
                    children[i] = new QTree(x + width / 2, y, width / 2, bitmap);
                    break;
                case 2:
                    children[i] = new QTree(x + width / 2, y + width / 2, width / 2, bitmap);
                    break;
            }
        }
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        for (int i = 0; i < children.length; i++) {
            switch (i) {
                /**
                 * The order of nodes is: 1 2 3 4
                 */
                case 0:
                    children[i].root.fillBitmap(x, y, width / 2, bitmap);
                    break;
                case 3:
                    children[i].root.fillBitmap(x, y + width / 2, width / 2, bitmap);
                    break;
                case 1:
                    children[i].root.fillBitmap(x + width / 2, y, width / 2, bitmap);
                    break;
                case 2:
                    children[i].root.fillBitmap(x + width / 2, y + width / 2, width / 2, bitmap);
                    break;
            }
        }
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("1");
            for (QTree child : children) {
                child.writeQTree(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(WhiteLeaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
