package com.example.td1_3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class HelloApplication extends Application {

    //Global attributes
    Pane racine = new Pane();
    GridPane app = new GridPane();

    private static int nb_lignes = 10;
    private static int nb_col = 10;
    private static int nbCases =  nb_lignes * nb_col;
    private static int largeur = 50;
    private static int hauteur = 50;
    private static int nb_pions_noirs = 20;
    private static int nb_pions_blancs = 20;

    @Override
    public void start(Stage stage) throws IOException
    {
        GridPane.setHalignment(app, HPos.CENTER);
        GridPane.setValignment(app, VPos.CENTER);

        //Vars
        Color couleur;
        double x, y;
        int diametre;
        int countCases = 0;
        String change;
        Scanner sc = new Scanner(System.in);

        //Creation damier
        System.out.print("Voulez-vous personnaliser le damier ? (oui/non)\n>> ");
        change = sc.nextLine().toLowerCase();

        try
        {
            if (change.equals("oui"))
            {
                System.out.print("Largeur en pixels :\n>> ");
                largeur = sc.nextInt();

                System.out.print("Hauteur en pixels :\n>> ");
                hauteur = sc.nextInt();

                System.out.print("Nombre de lignes :\n>> ");
                nb_lignes = sc.nextInt();

                System.out.print("Nombre de colonnes :\n>> ");
                nb_col = sc.nextInt();

                nbCases = nb_lignes * nb_col;

                System.out.print("Nombre de pions blancs\n>> ");
                nb_pions_blancs = sc.nextInt();

                System.out.print("Nombre de pions noirs\n>> ");
                nb_pions_noirs = sc.nextInt();

                if (nb_pions_noirs + nb_pions_blancs > (nbCases / 2)) {
                    throw new TropDePionsException("Trop de pions a placer sur le damier.");
                }
            }

            for (int j = 0; j < nb_col; j++)
            {
                for (int i = 0; i < nb_lignes; i++)
                {
                    //Cases
                    if (i % 2 == j % 2) couleur = Color.BROWN;
                    else couleur = Color.BEIGE;

                    Rectangle r = new Rectangle(0, 0, largeur, hauteur);
                    r.setFill(couleur);
                    r.setStroke(Color.BLACK);
                    app.add(r,i,j);
                    countCases++;

                    //Pions
                    if (i % 2 == j % 2)
                    {
                        diametre = Math.min(largeur, hauteur) / 2;
                        Circle pion = new Circle(0, 0, diametre);

                        if (nb_pions_blancs > 0)
                        {
                            pion.setFill(Color.WHITE);
                            pion.setStroke(Color.BLACK);
                            nb_pions_blancs--;
                            app.add(pion, i, j);
                        }
                        else if ((nbCases - countCases) / 2 < nb_pions_noirs)
                        {
                            pion.setFill(Color.BLACK);
                            pion.setStroke(Color.WHITE);
                            nb_pions_noirs--;
                            app.add(pion, i, j);
                        }
                    }
                }
            }
        }
        catch (TropDePionsException e)
        {
            e.printStackTrace();
        }

        racine.getChildren().addAll(app);
        stage.setScene(new Scene(racine));
        stage.setTitle("Damier Hugo COLLIN");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}