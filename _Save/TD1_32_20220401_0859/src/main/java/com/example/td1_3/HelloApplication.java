package com.example.td1_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //Global attributes
    Pane racine = new Pane();
    private static int nb_lignes = 10;
    private static int nb_col = 10;
    private static int nbCases =  nb_lignes * nb_col;
    private static int largeur = 75;
    private static int hauteur = 50;
    private static int nb_pions_noirs = 22;
    private static int nb_pions_blancs = 15;

    private static Color couleur;

    @Override
    public void start(Stage stage) throws IOException
    {
        double x, y;
        int diametre;
        int countCases = 0;
        for (int j = 0; j < nb_col; j ++)
        {
            for (int i = 0; i < nb_lignes; i ++)
            {
                //Cases
                if (i % 2 == j % 2) couleur = Color.BROWN;
                else couleur = Color.BEIGE;

                Rectangle r = new Rectangle(i*largeur, j*hauteur, largeur, hauteur);
                r.setFill(couleur);
                r.setStroke(Color.BLACK);
                racine.getChildren().addAll(r);
                countCases ++;

                //Pions
                if (i % 2 == j % 2 && (j < 4 || j > 5))
                {
                    x = i*largeur + largeur/2; //(i+1)*l*0.75; // - i*l/2; //i/2*l;
                    y = j*hauteur + hauteur/2; // - j*l/2;
                    diametre = (Math.min(largeur, hauteur)-5)/2;
                    System.out.println(x + "\n" + y + "\n");

                    if (j < 4 && nb_pions_blancs > 0)
                    {
                        Circle pion = new Circle (x, y, diametre);
                        pion.setFill(Color.WHITE);
                        pion.setStroke(Color.BLACK);
                        nb_pions_blancs --;

                        pion.setStrokeWidth(2);
                        racine.getChildren().addAll(pion);

                    }
                    else if (j > 5 && (nbCases - countCases) / 2 - nb_pions_noirs < 0)
                    {
                        Circle pion = new Circle (x, y, diametre);
                        pion.setFill(Color.BLACK);
                        pion.setStroke(Color.WHITE);
                        nb_pions_noirs --;

                        pion.setStrokeWidth(2);
                        racine.getChildren().addAll(pion);
                    }






                }


            }
        }

        Scene scene = new Scene(racine, nb_lignes *largeur, nb_col *hauteur);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}