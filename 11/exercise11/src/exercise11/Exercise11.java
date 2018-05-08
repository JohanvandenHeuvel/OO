/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author johan
 */
public class Exercise11 extends Application {

    double foo = 0;

    @Override
    public void start(Stage primaryStage) {

        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button quit = new Button("Quit");
        ProgressBar pb = new ProgressBar(0);
        TextField tf = new TextField();

        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            pb.setProgress(pb.getProgress() - ((double) (1 / foo)));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        start.setOnAction((ActionEvent event) -> {
            pb.setProgress(1.0);
            foo = Integer.parseInt(tf.getText());
            timeline.play();
        });

        stop.setOnAction((ActionEvent event) -> {
            timeline.stop();
        });

        quit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });

        Pane root = new Pane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);

        grid.add(pb, 0, 0, 2, 1);
        grid.add(tf, 1, 1);
        grid.add(start, 2, 1);
        grid.add(stop, 1, 2);
        grid.add(quit, 2, 2);

        Scene scene = new Scene(grid, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void tickHandler() {

    }

}
