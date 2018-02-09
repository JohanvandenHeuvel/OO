/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import static excercise2.Helper.queryUser;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author johan
 */
public class Gallows {

    private StringBuilder sb;
    private final String word;
    private int error;
    private final int limit = 10;

    /**
     * Constructor using random word
     */
    public Gallows() {
        error = 0;

        String filename = "words.txt";
        WordReader wr = new WordReader(filename);
        this.word = wr.getWord();

        char[] chars = new char[word.length()];
        Arrays.fill(chars, '.');
        this.sb = new StringBuilder(new String(chars));
    }

    /**
     * Constructor given word
     *
     * @param word
     */
    public Gallows(String word) {
        error = 0;

        this.word = word;

        char[] chars = new char[word.length()];
        Arrays.fill(chars, '.');
        this.sb = new StringBuilder(new String(chars));
    }

    /**
     * Play a game of "galgje"
     */
    public void playGame() {
        Boolean winCondition = false;
        Boolean loseCondition = false;

        System.out.println(sb);

        while (!winCondition && !loseCondition) {
            char ch = queryUser();
            int index = word.indexOf(ch);

            if (index >= 0) {
                System.out.println("Correct guess");
                updateStringBuilder(ch);
            } else {
                error = error + 1;
                System.out.println("Wrong guess, error:" + error);
            }

            System.out.println(sb);

            if (word.equals(sb.toString())) {
                winCondition = true;
            }

            if (error >= limit) {
                loseCondition = true;
            }
        }

        if (loseCondition) {
            System.out.println("You lost");
        }

        if (winCondition) {
            System.out.println("You won");
        }
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
            sb.setCharAt(i, ch);
        }
    }

}
