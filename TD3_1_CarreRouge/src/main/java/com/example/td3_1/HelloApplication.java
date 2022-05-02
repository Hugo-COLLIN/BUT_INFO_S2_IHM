//Laisser activé Maven
package com.example.td3_1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //Global attribute
    private static final int CST = 10;
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 500;

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        Rectangle rRed = new Rectangle( 245, 245, 10, 10);
        rRed.setFill(Color.RED);

        root.getChildren().addAll(rRed);


        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                if (rRed.getX() >= scene.getWidth() - CST)
                    rRed.setX(rRed.getX() - CST);
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                if (rRed.getY() >= scene.getHeight() - CST)
                    rRed.setY(rRed.getY() - CST);
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() { //A definir sur la scène, pas sur l'objet
            @Override
            public void handle(KeyEvent kE) {
                switch (kE.getCode()){
                    case UP: case Z:
                        if (rRed.getY() >= CST)
                            rRed.setY(rRed.getY() - CST);
                        break;
                    case DOWN: case W:
                        if (rRed.getY() <= scene.getHeight() - CST * 2)
                            rRed.setY(rRed.getY() + CST);
                        break;
                    case RIGHT: case S:
                        if (rRed.getX() <= scene.getWidth() - CST * 2)
                            rRed.setX(rRed.getX() + CST);
                        break;
                    case LEFT: case Q:
                        if (rRed.getX() >= CST)
                            rRed.setX(rRed.getX() - CST);
                        break;
                    default:
                        break;
                }
            }
        });
        //https://javadoc.scijava.org/javafx11/javafx.graphics/javafx/scene/layout/Region.html#widthProperty()
        //widthProperty();

        stage.setTitle("Carré rouge - Hugo COLLIN");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}