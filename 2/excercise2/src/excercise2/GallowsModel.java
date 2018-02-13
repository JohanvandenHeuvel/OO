/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Model of Gallows, according to the MVC paradigm.
 * The model represents data and the rules that govern access to 
 * and updates of this data. In enterprise software, 
 * a model often serves as a software approximation 
 * of a real-world process.
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GallowsModel {

    private StringBuilder correctGuessed;
    private final String word;
    private int error;
    private final int errorLimit = 10;

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
     * Checks if character occurs in word. 
     * If the character does occur the correctGuessed is updated
     * If the character does not occur the error is incremented by one
     * @param ch guessed character
     * @return Boolean if correct guess
     */
    public Boolean makeGuess(char ch) {
        int index = word.indexOf(ch);

        if (index >= 0) {
            updateStringBuilder(ch);
            return true;
        }

        error = error + 1;
        return false;
    }

    /**
     * @param ch character to look for
     * @return list of indexes of ch in word
     */
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
        return error >= errorLimit;
    }

    public int getError() {
        return error;
    }

    public String getCorrectGuessed() {
        return correctGuessed.toString();
    }
    
    /**
     * Only returns word if won or lost
     * @return word to be guessed
     */
    public String solution(){
        if(loseCondition() || winCondition()){
            return word;
        }
        return "";
    }
}
