package com.example.td1_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane racine = new Pane();

        Circle cercleR = new Circle(150,150,100, Color.RED);
        //cercleR.setFill(Color.RED);
        cercleR.setStroke(Color.BLACK);
        cercleR.setStrokeWidth(4);

        /*
        Text iut = new Text(100,150,"IUT\nNancy-Charlemagne");
        //iut.setStyle("-fx-alignment: CENTER-RIGHT");
        iut.setTextAlignment(TextAlignment.CENTER);
        iut.setFont(Font.font("helvetica", 20));
        */

        Text iut = new Text(110,120,"IUT");
        iut.setFont(Font.font("helvetica", 40));
        iut.setFill(Color.WHITE);

        Text nc = new Text(70,150,"Nancy-Charlemagne");
        nc.setFont(Font.font("verdana", 17));
        nc.setFill(Color.WHITE);

        Text info = new Text(90,180,"Informatique");
        info.setFont(Font.font("verdana", 18));
        info.setFill(Color.BLACK);


        Circle cP = new Circle(250,190,20,Color.web("#9d8dcf", 0.7));
        cP.setStroke(Color.BLACK);

        Circle cR = new Circle(160,250,30,Color.web("#dc63ff", 0.5));
        cR.setStroke(Color.BLACK);

        Circle cV = new Circle(220,90,30,Color.web("#00ff00", 0.5));
        cV.setStroke(Color.BLACK);

        Circle cB = new Circle(110,60,40,Color.web("#00ffff", 0.5));
        cB.setStroke(Color.BLACK);

        Circle cJ = new Circle(60,150,50,Color.web("#ffff00", 0.5));
        cJ.setStroke(Color.BLACK);




        racine.getChildren().addAll(cercleR, iut, nc, info,cP, cR, cV, cB, cJ);

        Scene scene = new Scene(racine, 300, 300);
        stage.setScene(scene);
        stage.show();

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

         */
    }

    public static void main(String[] args) {
        launch();
    }
}