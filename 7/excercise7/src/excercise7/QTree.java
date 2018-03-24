package excercise7;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class QTree {

    QTNode root;

    public QTree(Reader input) {
        root = readQTree(input);
    }

    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
    }

    public QTree(int x, int y, int width, Bitmap bitmap) {
        root = bitmap2QTree(x, y, width, bitmap);
    }

    /**
     * Fill given bitmap according to the QTree
     *
     * @param bitmap
     */
    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    /**
     * Give a string of bits according to the QTree
     *
     * @param sb
     */
    public void writeQTree(Writer sb) {
        root.writeNode(sb);
    }

    /**
     * Construct a QTree given a string of bits
     *
     * @param input
     * @return
     */
    private static QTNode readQTree(Reader input) {
        try {
            // 49 for '1'
            // 48 for '0'
            int nextChar = input.read();
            if (nextChar == 49) {
                return new GrayNode(input);
            }
            if (nextChar == 48) {
                nextChar = input.read();
                if (nextChar == 48) {
                    return new BlackLeaf();
                }
                if (nextChar == 49) {
                    return new WhiteLeaf();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Convert given bitmap to a QTree
     *
     * @param x
     * @param y
     * @param width
     * @param bitmap
     * @return
     */
    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        if (allWhite(x, y, width, bitmap)) {
            return new WhiteLeaf();
        }
        if (allBlack(x, y, width, bitmap)) {
            return new BlackLeaf();
        }
        if (width > 1) {
            return new GrayNode(x, y, width, bitmap);
        }

        return null;
    }

    /**
     * Check if area of bitmap is all white
     *
     * @param x
     * @param y
     * @param width
     * @param bitmap
     * @return
     */
    public static boolean allWhite(int x, int y, int width, Bitmap bitmap) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + width; j++) {
                if (!bitmap.getBit(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if area of bitmap is all black
     *
     * @param x
     * @param y
     * @param width
     * @param bitmap
     * @return
     */
    public static boolean allBlack(int x, int y, int width, Bitmap bitmap) {
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + width; j++) {
                if (bitmap.getBit(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
