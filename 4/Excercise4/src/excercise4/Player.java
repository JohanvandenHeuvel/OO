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
public interface Player {
    public void setColor(Field f);
    public Field getColor();
    public void takeTurn(Board board, Player opponent);
}
