/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise6;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public enum Direction
{
    NORTH (-1,0), EAST (0,1), SOUTH(1,0), WEST(0,-1);
    
    private final int dx, dy;
    private Direction (int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    public int GetDX () {
        return dx;
    }

    public int GetDY () {
        return dy;
    }
}
