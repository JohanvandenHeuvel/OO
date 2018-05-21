/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise12;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author Johan van den Heuvel s47704528
 * @author Niels Korporaal s4768256
 */
public class Exercise12 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        ArrayList<Circle> beads = new ArrayList<>();
        beads.add(new Circle(200, 200, 10, Color.BLUE));

        Line line = new Line(-10, 0, beads.get(0).getCenterX(), beads.get(0).getCenterY());

        group.getChildren().add(beads.get(0));
        group.getChildren().add(line);

        Scene scene = new Scene(group, 300, 250);

        scene.setOnMouseMoved((MouseEvent e) -> {
            /**
             * For optimalization the color could be set on initialization
             * instead of every move. However this is easier to implement and
             * optimalization is not important for this.
             */

            /**
             * For the exam, would it be important to follow the mvc principle
             * for something like this? Or would that be mentioned? Maybe not
             * explicit like " use this principle" but like "you should use a
             * principle about this and this".
             */
            
            line.setEndX(e.getX());
            line.setEndY(e.getY());

            for (int i = 0; i < beads.size(); i++) {

                double offsetX = line.getEndX() / beads.size();
                double offsetY = line.getEndY() / beads.size();

                double locationX = line.getEndX() - (i * offsetX);
                double locationY = line.getEndY() - (i * offsetY);

                double relativeLocation = locationX / line.getEndX();

                beads.get(i).setFill(Color.rgb((int) ((1 - relativeLocation) * 255.0), 0, (int) (relativeLocation * 255.0)));

                beads.get(i).setCenterX(locationX);
                beads.get(i).setCenterY(locationY);

            }
        });

        scene.setOnMouseClicked((MouseEvent e) -> {
            beads.add(new Circle(0, 0, 10, Color.RED));
            group.getChildren().add(beads.get(beads.size() - 1));
        });

        primaryStage.setTitle("Exercise 12");
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
