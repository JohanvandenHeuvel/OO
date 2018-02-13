/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import java.util.Scanner;

/**
 * The View of Gallows, according to the MVC paradigm.
 * The view renders the contents of a model. 
 * It specifies exactly how the model data should be presented.
 * If the model data changes, 
 * the view must update its presentation as needed.
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GallowsView {

    /**
     * Query the user to enter a character
     * @return first character of entered string
     */
    public static char queryUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a letter to make a guess:");
        String s = reader.next();
        return s.charAt(0);
    }

    public static void printGameState(GallowsModel gallowsModel, Boolean guess) {
        System.out.println(gallowsModel.getCorrectGuessed());
        System.out.println((guess) ? ("Correct guess") : ("Wrong guess, error:" + gallowsModel.getError()));
        System.out.println("");

        if (gallowsModel.loseCondition()) {
            System.out.println("You lost");
            System.out.println("The correct word is: " + gallowsModel.solution());
        }

        if (gallowsModel.winCondition()) {
            System.out.println("You won");
            System.out.println("The correct word is: " + gallowsModel.solution());
        }
    }
}
