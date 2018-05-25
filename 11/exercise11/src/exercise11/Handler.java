/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Handler {

    Exercise11 e;
    double tickAmount;

    final private Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
        tickerEvent();
    }));

    public Handler(Exercise11 e) {
        this.e = e;
        timeline.setCycleCount(Timeline.INDEFINITE);

    }

    void tickerEvent() {
        e.getPb().setProgress(e.getPb().getProgress() - ((double) (1 / tickAmount)));
    }

    void startTimeLine() {
        tickAmount = Double.parseDouble(e.getTf().getText());
        if (e.getPb().getProgress() <= 0) {
            e.getPb().setProgress(1.0);
            e.getGrid().setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        timeline.play();
    }

    void stopTimeLine() {
        timeline.stop();
    }

    void quitTimeLine() {
        System.exit(0);
    }

    void changeBackgroud() {
        if (e.getPb().getProgress() <= 0) {
            e.getGrid().setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

}
