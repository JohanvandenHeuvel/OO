/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Board {

    private final int NR_COL = 10;
    private final int NR_ROW = 10;
    private final Field[][] board;

    public Board() {
        this.board = new Field[NR_ROW][NR_COL];

        //Fill the board with empty fields
        for (int i = 0; i < NR_COL; i++) {
            for (int j = 0; j < NR_ROW; j++) {
                this.board[i][j] = Field.EMPTY;
            }
        }
    }

    public Board(Field[][] board) {
        this.board = new Field[NR_ROW][NR_COL];

        //copy the board
        for (int i = 0; i < NR_COL; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, NR_ROW);
        }
    }

    /**
     * Add a new piece to a specified column for a player
     *
     * @param col
     * @param p
     */
    public void addNewField(int col, Player p) {
        for (int i = NR_ROW - 1; i >= 0; i--) {
            if (this.board[i][col] == Field.EMPTY) {
                this.board[i][col] = p.getColor();
                return;
            }
        }
    }

    /**
     * Check for each non-empty field on the board if it is part of a win
     *
     * @param p
     * @return
     */
    public boolean winning(Player p) {
        for (int i = 0; i < NR_ROW; i++) {
            for (int j = 0; j < NR_COL; j++) {
                if (this.board[i][j] != Field.EMPTY) {
                    if (check(i, j, p)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check all directions from a field
     *
     * @param i
     * @param j
     * @param p
     * @return
     */
    public boolean check(int i, int j, Player p) {
        int counter;

        //Check vertical
        counter = 0;
        if (j - 3 >= 0) {
            for (int k = 0; k < 4; k++) {
                if (this.board[i][j - k] == p.getColor()) {
                    counter++;
                }
            }
        }
        if (counter == 4) {
            return true;
        }

        //Check horizontal
        counter = 0;
        if (i - 3 >= 0) {
            for (int k = 0; k < 4; k++) {
                if (this.board[i - k][j] == p.getColor()) {
                    counter++;
                }
            }
        }
        if (counter == 4) {
            return true;
        }

        //Check diagonal
        counter = 0;
        if (i - 3 >= 0 && j + 3 < NR_COL) {
            for (int k = 0; k < 4; k++) {
                if (this.board[i - k][j + k] == p.getColor()) {
                    counter++;
                }
            }
        }
        if (counter == 4) {
            return true;
        }

        counter = 0;
        if (i - 3 >= 0 && j - 3 >= 0) {
            for (int k = 0; k < 4; k++) {
                if (this.board[i - k][j - k] == p.getColor()) {
                    counter++;
                }
            }
        }
        if (counter == 4) {
            return true;
        }

        return false;
    }

    /**
     * Returns a mutable copy of the current Board state
     *
     * @return
     */
    public Board copy() {
        Field[][] copy = new Field[NR_ROW][NR_COL];
        for (int i = 0; i < NR_ROW; i++) {
            System.arraycopy(this.board[i], 0, copy[i], 0, NR_COL);
        }
        return new Board(copy);
    }

    public int getNR_COL() {
        return NR_COL;
    }

    public int getNR_ROW() {
        return NR_ROW;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < NR_ROW; i++) {
            for (int j = 0; j < NR_COL; j++) {
                s = s + this.board[i][j] + " ";
            }
            s = s + "\n";
        }
        for (int i = 0; i < NR_COL; i++) {
            s = s + i + " ";
        }
        return s;
    }
}
