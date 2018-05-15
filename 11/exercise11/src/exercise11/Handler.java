/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise11;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Handler {

    static void tickerEvent(Exercise11 e) {
        e.getPb().setProgress(e.getPb().getProgress() - ((double) (1 / e.getTickAmount())));
    }

    static void startTimeLine(Exercise11 e) {
        if(e.getPb().getProgress() <= 0){
            e.getPb().setProgress(1.0);
            e.getGrid().setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        e.getTimeline().play();
    }

    static void stopTimeLine(Exercise11 e) {
        e.getTimeline().stop();
    }

    static void quitTimeLine(Exercise11 e) {
        System.exit(0);
    }

    static void changeBackgroud(Exercise11 e) {
        if (e.getPb().getProgress() <= 0) {
            e.getGrid().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

}
