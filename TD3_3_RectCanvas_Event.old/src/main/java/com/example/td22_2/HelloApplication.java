package com.example.td22_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    //Attributes
    public static final int SIZE = 300;

    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        stage.setScene(new Scene(root));

        Canvas canvas = new Canvas(SIZE,SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scanner sc = new Scanner(System.in);
        int nbRect;

        do {
            System.out.print("Rentrer un nombre entier de carrés à afficher : ");
            nbRect = sc.nextInt();
        }
        while (nbRect < 0);


        for (int i = 0 ; i < nbRect ; i ++)
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