/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise6;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class SlidingGame implements Configuration {

    public static final int N = 4, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private int[][] board;
    private int holeX, holeY;
    private SlidingGame parent;

    /**
     * A constructor that initializes the board with the specified array and
     * differs from its parent with dir
     *
     * @param parent: the parent node
     * @param dir: the direction in which this successor moves
     */
    public SlidingGame(SlidingGame parent, Direction dir) {
//        use the normal constructor
        this(parent.flattenBoard());
        this.parent = parent;

//        then do the move
        int x = holeX + dir.GetDX();
        int y = holeY + dir.GetDY();

        board[holeX][holeY] = board[x][y];
        board[x][y] = HOLE;
        holeX = x;
        holeY = y;
    }

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
//            changed this to row instead of colum first
            board[p / N][p % N] = start[p];
            if (start[p] == HOLE) {
                holeX = p / N;
                holeY = p % N;
            }
        }
        this.parent = null;
    }

    /**
     * Creates a flattened copy of the board
     *
     * @return
     */
    public int[] flattenBoard() {
        int[] flatBoard = new int[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flatBoard[N * i + j] = board[i][j];
            }
        }

        return flatBoard;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                buf.append((board[i][j] == HOLE) ? ". " : board[i][j] + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }

    /**
     * Is this game solved or not
     *
     * @return
     */
    @Override
    public boolean isSolution() {
        int counter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (counter == N * N - 1) {
                    return true;
                }
                if (board[i][j] == counter + 1) {
                    counter++;
                } else {
                    return false;
                }
            }

        }
        return false;
    }

    /**
     *
     * @return list of a configurations reachable from current configuration
     */
    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList<>();

//        Move east
        if (holeY + 1 < N) {
            successors.add(new SlidingGame(this, Direction.EAST));
        }
//        Move west
        if (holeY > 0) {
            successors.add(new SlidingGame(this, Direction.WEST));
        }
//        Move north
        if (holeX > 0) {
            successors.add(new SlidingGame(this, Direction.NORTH));
        }
//        Move south
        if (holeX + 1 < N) {
            successors.add(new SlidingGame(this, Direction.SOUTH));
        }

        return successors;
    }

    @Override
    public Configuration parent() {
        return parent;
    }

    @Override
    public int compareTo(Configuration o) {
        int distanceA = heuristic();
        int distanceB = ((SlidingGame) o).heuristic();

        return Integer.compare(distanceA, distanceB);
    }

    public static int getN() {
        return N;
    }

    public boolean isSolvable() {

        int[] numbers = flattenBoard();

        int parity = 0;
        int gridWidth = N;
        int row = 0; // the current row we are on
        int blankRow = 0; // the row with the blank tile

        for (int i = 0; i < numbers.length; i++) {
            if (i % gridWidth == 0) { // advance to next row
                row++;
            }
            if (numbers[i] == HOLE) { // the blank tile
                blankRow = row; // save the row on which encountered
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j] && numbers[j] != 0) {
                    parity++;
                }
            }
        }

        if (gridWidth % 2 == 0) { // even grid
            if (blankRow % 2 == 0) { // blank on odd row; counting from bottom
                return parity % 2 == 0;
            } else { // blank on even row; counting from bottom
                return parity % 2 != 0;
            }
        } else { // odd grid
            return parity % 2 == 0;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int x = N - 1; x >= 0; x--) {
            for (int y = N - 1; y >= 0; y--) {
                hash = 31 * hash + board[x][y];
            }
        }
        return hash;
    }

    /**
     * Implementation of Manhattan distance heuristic
     *
     * @return
     */
    public int heuristic() {
        int sum = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                for (int rowCorrect = 0; rowCorrect < N; rowCorrect++) {
                    for (int colCorrect = 0; colCorrect < N; colCorrect++) {
                        if (this.board[row][col] == correctPuzzle()[rowCorrect][colCorrect]) {
                            sum += Math.abs(row - rowCorrect) + Math.abs(col - colCorrect);
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * Initialize the goal congfiguration, this helps with the heuristic
     * @return 
     */
    public static int[][] correctPuzzle() {
        int[][] board = new int[N][N];
        int counter = 1;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (counter <= N * N - 1) {
                    board[row][col] = counter;
                    counter++;
                }
            }
        }
        return board;
    }
}
