/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise6;

import java.util.Collection;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Excercise6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        TODO: int is not big enough for hash code for bigger N
//        TODO: manual declaration of N in SlidingGame sucks
        
        int[] start = {
            9, 3, 6, 12,
            10, 1, 7, 16,
            13, 2, 4, 5,
            11, 8, 15, 14};
//
//        int[] start = {
//            1, 8, 3,
//            6, 2, 7,
//            4, 9, 5};

        SlidingGame game = new SlidingGame(start);
        System.out.println(game);

        Solver s = new Solver(game);
        System.out.println(game.isSolvable());

        Configuration slt = s.solve();
        Collection<Configuration> path = slt.pathFromRoot();
        for (Configuration node : path) {
            System.out.println(node);
        }

    }

}
