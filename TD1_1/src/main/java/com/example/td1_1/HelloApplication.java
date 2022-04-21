package com.example.td1_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(racine, 790, 175);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

         */
        Pane racine = new Pane();

        Rectangle rect = new Rectangle(0,0, 75, 175);
        rect.setFill((Color.BLUE));

        Rectangle rect2 = new Rectangle(715,0, 75, 175);
        rect2.setFill((Color.BLUE));

        Circle cercle = new Circle(40,40,25);
        cercle.setFill(Color.BLUE);
        cercle.setStroke(Color.WHITE);

        Rectangle img = new Rectangle(720, 5, 65,65);
        img.setFill(Color.BLUE);
        img.setStroke(Color.WHITE);

        Text f = new Text(15,160,"F");
        f.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 90));
        f.setFill(Color.WHITE);
        //f.prefHeight(1000);

        Text dpt = new Text(720,160,"54");
        dpt.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 60));
        dpt.setFill(Color.WHITE);

        racine.getChildren().addAll(rect,rect2, cercle, img, f, dpt);
        Scene scene = new Scene(racine, 790, 175);
        stage.setScene(scene);
        stage.setTitle("Immatriculation");
        stage.show();



        /*
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
        */




    }

    public static void main(String[] args) {
        launch();
    }
}