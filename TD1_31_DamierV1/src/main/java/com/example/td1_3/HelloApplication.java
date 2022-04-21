package com.example.td1_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane racine = new Pane();
        final int NB_LIGNES = 10;
        final int NB_COL = 10;
        int l = 100;
        Color couleur;

        for (int j = 0 ; j < NB_COL ; j ++)
        {
            for (int i = 0 ; i < NB_LIGNES ; i ++)
            {
                //Cases
                if (i % 2 == j % 2) couleur = Color.BROWN;
                else couleur = Color.BEIGE;

                Rectangle r = new Rectangle(i*l, j*l, l,l);
                r.setFill(couleur);
                r.setStroke(Color.BLACK);
                racine.getChildren().addAll(r);

                //Pions
                if (i % 2 == j % 2 && j > 5)
                {
                    double x = i*l + l/2; //(i+1)*l*0.75; // - i*l/2; //i/2*l;
                    double y = j*l + l/2; // - j*l/2;
                    System.out.println(x + "\n" + y + "\n");

                    Circle pion = new Circle (x, y, (l-5)/2);
                    pion.setFill(Color.WHITE);
                    pion.setStroke(Color.BLACK);
                    pion.setStrokeWidth(2);
                    racine.getChildren().addAll(pion);
                }


            }
        }

        Scene scene = new Scene(racine, NB_LIGNES*l,NB_COL*l);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}