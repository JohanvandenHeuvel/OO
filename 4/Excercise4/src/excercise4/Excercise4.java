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
public class Excercise4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< HEAD
        Player p1 = new HumanPlayer(Field.RED, "player X");
        Player p2 = new HumanPlayer(Field.YELLOW, "player O");
        Player p3 = new ComputerPlayer(Field.YELLOW, "player O", new RuleBasedStrategy());
        Player p4 = new ComputerPlayer(Field.YELLOW, "player O", new RuleBasedStrategy());
=======
        Player p1 = new HumanPlayer(Field.RED, "player 1");
        Player p2 = new HumanPlayer(Field.YELLOW, "player 2");
        Player p3 = new ComputerPlayer(Field.RED, "player 3", new RuleBasedStrategy());
        Player p4 = new ComputerPlayer(Field.YELLOW, "player 4", new RuleBasedStrategy());
>>>>>>> master
        
        Player[] players = {p4,p3};
        
        Board b = new Board();
        Game g = new Game(players, b);
        
        Player winner = g.playTurn();
        IO.printWinner(winner);
    }
    
}
