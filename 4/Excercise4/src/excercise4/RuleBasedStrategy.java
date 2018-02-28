/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

import java.util.Random;

/**
 *
 * @author johan
 */
public class RuleBasedStrategy implements Strategy {

    @Override
    public int runStrategy(Board b, Player p, Player opponent) {
        
        for (int i = 0; i < b.getNR_COL(); i++) {
            if (nextMoveWin(b, p, opponent, i)) {
                continue;
            }
            if (winningMove(b, p, i)) {
                return i;
            }
            if (fork(b, opponent, i)){
                return i;
            }
            
        }
        return randomMove();
    }
    
    /**
     * 
     * If I have a winning move, take it
     * If the opoonent has a wining move, block it
     * @param b
     * @param p
     * @param i
     * @return 
     */
    public boolean winningMove(Board b, Player p, int i) {
        Board temp = b.copy();
        temp.addNewField(i, p);
        return temp.winning(p, i);
    }

    /**
     * If the opponent has a move that results in two winning conditions, block it
     * @param i
     * @return 
     */
    public boolean fork(Board b, Player opponent, int i) {
        Board temp = b.copy();
        temp.addNewField(i, opponent);
        
        int winCounter = 0;
        for (int j = 0; j < b.getNR_COL(); j++) {
            Board temp2 = temp.copy();
            temp2.addNewField(j, opponent);
            if (winningMove(temp, opponent, i)) {
                winCounter++;
            }
        }
        return winCounter > 1;
    }

    /**
     * Prevent move if would result in loss next turn
     * @param b
     * @param p
     * @param opponent
     * @param i
     * @return 
     */
    public boolean nextMoveWin(Board b, Player p, Player opponent, int i) {
        Board temp = b.copy();
        temp.addNewField(i, p);
        
        for (int j = 0; j < b.getNR_COL(); j++) {
            if(winningMove(temp, opponent, i)){
                return true;
            }
        }
        return false;
    }

    /**
     * Make best possible move, preference for middle of the board
     * @return 
     */
    public int randomMove() {
        Random rand = new Random();

        int  n = rand.nextInt(9);
        return n;
    }

}
