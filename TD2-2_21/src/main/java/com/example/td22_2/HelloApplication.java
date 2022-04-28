package com.example.td22_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //Attributes
    public static final int SIZE = 300;

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        stage.setScene(new Scene(root));

        Canvas canvas = new Canvas(SIZE,SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 0 ; i < 1000 ; i ++)
        {
            gc.setFill(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255), Math.random()));
            gc.fillRect(Math.random() * SIZE, Math.random() * SIZE, Math.random() * SIZE, Math.random() * SIZE);
        }

        root.getChildren().add(canvas);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}