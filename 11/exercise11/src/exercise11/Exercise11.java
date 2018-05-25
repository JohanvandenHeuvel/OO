/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Exercise11 extends Application {

    final private Button start = new Button("Start");
    final private Button stop = new Button("Stop");
    final private Button quit = new Button("Quit");
    final private ProgressBar pb = new ProgressBar(0);

    final private TextField tf = new TextField();

    final private GridPane grid = new GridPane();
    
    Handler h = new Handler(this);

    @Override
    public void start(Stage primaryStage) {

        pb.setMaxWidth(999999); //Otherwise will not fill the length in grid

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);

        grid.add(pb, 0, 0, 3, 1);
        grid.add(tf, 1, 1);
        grid.add(start, 2, 1);
        grid.add(stop, 1, 2);
        grid.add(quit, 2, 2);

        start.setOnAction(e -> {
            h.startTimeLine();
        });

        stop.setOnAction(e -> {
            h.stopTimeLine();
        });

        quit.setOnAction(e -> {
            h.quitTimeLine();
        });

        pb.progressProperty().addListener(o -> {
            h.changeBackgroud();
        });

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setTitle("Kitchen timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public GridPane getGrid() {
        return grid;
    }

    public ProgressBar getPb() {
        return pb;
    }

    public TextField getTf() {
        return tf;
    }
}
