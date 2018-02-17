/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

/**
 * The Controller of Gallows, according to the MVC paradigm.
 * The controller translates the user's interactions with the view into 
 * actions that the model will perform.
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class GallowsController {

    private GallowsModel gallowsModel;
    private GallowsView gallowsView;

    public GallowsController(GallowsModel gallowsModel, GallowsView gallowsView) {
        this.gallowsModel = gallowsModel;
        this.gallowsView = gallowsView;
    }

    /**
     * Play one round of "galgje". This round consists of asking the user to
     * input a character to guess. Then this character is passed on to make the
     * guess.
     * @return 
     */
    public Boolean playRound() {
        return gallowsModel.makeGuess(gallowsView.queryUser());
    }

    /**
     * Play "galgje" until won or lost. Every iteration the currect gameState
     * is printed by the View.
     */
    public void playGame() {
        while (!gallowsModel.winCondition() && !gallowsModel.loseCondition()) {
            gallowsView.printGameState(gallowsModel, playRound());
        }
    }
}
