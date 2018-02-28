/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise4;

/**
 * Class controlling the actions that Players take on the Board
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Game {

    private final Player[] players;
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
     * The current player takes a turn. If move played this turn is winning then
     * return current player. Else the next player plays a turn.
     *
     * @return
     */
    public Player playTurn() {
        do {
            nextPlayer();
            players[currentPlayer].takeTurn(board, getOpponent());
            IO.printBoard(board);
        } while (!board.winning(players[currentPlayer]));
        return players[currentPlayer];
    }

    public Player getOpponent() {
        int opponent = currentPlayer + 1;
        if (opponent >= players.length) {
            opponent = 0;
        }
        return players[opponent];
    }
}
