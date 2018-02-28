/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

/**
 * Class controlling the actions that Players take on the Board
 * @author johan
 */
public class Game {
    private Player[] players;
    private Board board;
    private int currentPlayer;

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = new Board();
        this.currentPlayer = 0;
    }

    /**
     * Loop through the players, i.e sequential turns.
     */
    public void nextPlayer() {
        currentPlayer++;
        if (currentPlayer >= players.length) {
            currentPlayer = 0;
        }
    }

    /**
     * The current player takes a turn.
     * If move played this turn is winning then return current player. 
     * Else the next player plays a turn.
     * @return 
     */
    public Player play() {
        int col = 0;
        do {   
            nextPlayer();
            col = players[currentPlayer].play(board);
            IO.printBoard(board);
        } while (!board.winning(players[currentPlayer], col)); 
        return players[currentPlayer];
    }
}
