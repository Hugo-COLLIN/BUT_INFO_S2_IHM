package com.example.td1_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

         */
        Pane racine = new Pane();
        Circle cercle = new Circle(75,75,70);
        //Circle cercle = new Circle(0,0,70);
        cercle.setFill(Color.RED);
        cercle.setStroke(Color.BLACK);
        Text texte = new Text();
        texte.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));


        texte.setFill(Color.WHITE);
        texte.setStroke(Color.BLACK);
        texte.setX(20);
        texte.setY(100);
        texte.setText("Stop");



        racine.getChildren().addAll(cercle,texte);
        Scene scene = new Scene(racine, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Panneau !");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}