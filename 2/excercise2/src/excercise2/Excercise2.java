/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

/**
 *
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Excercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GallowsModel gM = new GallowsModel("topkek");
        GallowsView gV = new GallowsView();
        GallowsController gC = new GallowsController(gM, gV);
        gC.playGame();
    }
}
