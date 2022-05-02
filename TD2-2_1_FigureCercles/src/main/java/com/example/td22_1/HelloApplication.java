package com.example.td22_1;

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
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        stage.setScene(new Scene(root));

        Canvas canvas = new Canvas(400,400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.setGlobalAlpha(0.5);
        gc.fillOval(125,75, 150, 150);

        gc.setFill(Color.GREEN);
        gc.setGlobalAlpha(0.5);
        gc.fillOval(70,170, 150, 150);

        gc.setFill(Color.BLUE);
        gc.setGlobalAlpha(0.5);
        gc.fillOval(195,170, 150, 150);



        root.getChildren().addAll(canvas);

        stage.setTitle("Figure - Hugo COLLIN");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}