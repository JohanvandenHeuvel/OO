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
public class Excercise4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player p1 = new HumanPlayer(Field.RED, "player 1");
        Player p2 = new HumanPlayer(Field.YELLOW, "player 2");
        Player p3 = new ComputerPlayer(Field.YELLOW, "player 3", new RuleBasedStrategy());
        
        Player[] players = {p1,p2};
        
        Board b = new Board();
        Game g = new Game(players, b);
        
        Player winner = g.playTurn();
        IO.printWinner(winner);
    }
    
}
