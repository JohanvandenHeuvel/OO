/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise12;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author johan
 */
public class Exercise12 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        ArrayList<Circle> beads = new ArrayList<Circle>();
        beads.add(new Circle(200, 200, 10, Color.BLUE));

        Line line = new Line(-10, 0, beads.get(0).getCenterX(), beads.get(0).getCenterY());

        group.getChildren().add(beads.get(0));
        group.getChildren().add(line);

        Scene scene = new Scene(group, 300, 250);

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                line.setEndX(e.getX());
                line.setEndY(e.getY());

                for (int i = 0; i < beads.size(); i++) {

                    double offsetX = line.getEndX() / beads.size();
                    double offsetY = line.getEndY() / beads.size();

                    beads.get(i).setCenterX(line.getEndX() - (i * offsetX));
                    beads.get(i).setCenterY(line.getEndY() - (i * offsetY));

                }

                System.out.println(beads.get(0).getCenterX());
                System.out.println(beads.get(0).getCenterY());

            }

        });

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                beads.add(new Circle(0, 0, 10, Color.RED));
                group.getChildren().add(beads.get(beads.size() - 1));
            }

        });

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

}
