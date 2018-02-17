/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GallowsModel {

    private StringBuilder correctGuessed;
    private StringBuilder allGuessed = new StringBuilder();
    private final String word;
    private int error;
    private final int limit = 10;

    public GallowsModel() {
        String filename = "words.txt";
        WordReader wr = new WordReader(filename);
        this.word = wr.getWord();

        restartGame();
    }

    public GallowsModel(String word) {
        this.word = word;

        restartGame();
    }

    public void restartGame() {
        error = 0;
        emptyStringBuilder();
    }

    /**
     *
     * @param ch guessed character
     * @return Boolean if correct guess
     */
    public Boolean makeGuess(char ch) {
        int index = word.indexOf(ch);
        updateAllGuessed(ch);
        if (index >= 0) {
            updateStringBuilder(ch);
            return true;
        }
        System.out.print("You guessed: ");
        printAllGuessed();
        error += 1;
        return false;
    }

    private ArrayList<Integer> indexCharInString(char ch) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                list.add(i);
            }
        }
        return list;
    }

    private void updateStringBuilder(char ch) {
        for (int i : indexCharInString(ch)) {
            correctGuessed.setCharAt(i, ch);
        }
    }

    private void emptyStringBuilder() {
        char[] chars = new char[word.length()];
        Arrays.fill(chars, '.');
        this.correctGuessed = new StringBuilder(new String(chars));
    }

    public Boolean winCondition() {
        return word.equals(correctGuessed.toString());
    }

    public Boolean loseCondition() {
        return error >= limit;
    }

    public int getError() {
        return error;
    }

    public String getCorrectGuessed() {
        return correctGuessed.toString();
    }

    public void updateAllGuessed(char ch) {
        this.allGuessed = allGuessed.append(Character.toString(ch));
    }

    public String getAllGuessed() {
        return allGuessed.toString();
    }

    private void printAllGuessed() {
        for (int i = 0; i < allGuessed.length(); i++) {
            System.out.print(allGuessed.charAt(i));
            if(i < allGuessed.length()-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
