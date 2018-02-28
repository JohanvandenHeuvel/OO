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
public class HumanPlayer implements Player {

    private Field color;
    private final String playerName;

    public HumanPlayer(Field color, String playerName) {
        this.color = color;
        this.playerName = playerName;
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
        int x = IO.queryInput();
        board.addNewField(x, this);
    }

    @Override
    public String toString() {
        return playerName;
    }

}
