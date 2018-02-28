/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

/**
 *
 * @author johan
 */
public class RuleBasedStrategy implements Strategy {

    @Override
    public int runStrategy(Board b, Player p) {
        for (int i = 0; i < b.getNR_COL(); i++) {
            if (winningMove(new Board(b.copy()), p, i)) {
                return i;
            }
            if (winningMove(new Board(b.copy()), p, i)) {
                return i;
            }
            if (fork(i)) {
                return i;
            }
            if (nextMoveWin(i)) {
                return i;
            }
        }
        return bestMove();
    }

    public boolean winningMove(Board b, Player p, int i) {
        b.addNewField(i, p);
//        return(b.winning(p));
        return false;
        /*
        player does not matter, you always want to make a 4 row if possible
        */
//        1. If I have a winning move, take it.
//        2. If the opponent has a winning move, block it.
    }

    public boolean fork(int i) {
//        3. If the opponent as a move that yields a fork (two winning moves), block it.
        return false;
    }

    public boolean nextMoveWin(int i) {
//        4. Prevent a own move that yields the opponent a winning move.
        return false;
    }

    public int bestMove() {
//        5. Make an allowed move preferably around the center of the board
        return -1;
    }

}
