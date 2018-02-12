/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import static excercise2.GallowsView.queryUser;

/**
 *
 * @author johan
 */
public class GallowsController {

    private GallowsModel gallowsModel;
    private GallowsView gallowsView;

    public GallowsController(GallowsModel gallowsModel, GallowsView gallowsView) {
        this.gallowsModel = gallowsModel;
        this.gallowsView = gallowsView;
    }

    public Boolean playRound() {
        return gallowsModel.makeGuess(queryUser());
    }

    public void playGame() {
        while (!gallowsModel.winCondition() && !gallowsModel.loseCondition()) {
            gallowsView.printGameState(gallowsModel, playRound());
        }
    }
}
