/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import java.util.Scanner;

/**
 *
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GallowsView {

    public static char queryUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a letter to make a guess:");
        String s = reader.next();
        return s.charAt(0);
    }

    public static void printGameState(GallowsModel gallowsModel, Boolean guess) {
        System.out.println(gallowsModel.getCorrectGuessed());
        System.out.println((guess) ? ("Correct guess") : ("Wrong guess:" + gallowsModel.getError()));

        if (gallowsModel.loseCondition()) {
            System.out.println("You lost");
        }

        if (gallowsModel.winCondition()) {
            System.out.println("You won");
        }
    }
}
