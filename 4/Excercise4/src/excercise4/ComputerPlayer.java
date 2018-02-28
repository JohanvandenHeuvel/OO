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
public class ComputerPlayer implements Player {

    private Field color;
    private final String playerName;
    private final Strategy strategy;

    public ComputerPlayer(Field color, String playerName, Strategy strategy) {
        this.color = color;
        this.playerName = playerName;
        this.strategy = strategy;
    }

    @Override
    public void setColor(Field f) {
        color = f;
    }

    @Override
    public Field getColor() {
        return color;
    }

    @Override
    public void takeTurn(Board board, Player opponent) {
        int x = strategy.runStrategy(board, this, opponent);
        board.addNewField(x, this);
    }

    @Override
    public String toString() {
        return playerName;
    }

}
