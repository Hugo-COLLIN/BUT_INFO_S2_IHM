package com.example.td1_3;

import javafx.application.Application;
import javafx.scene.Scene;
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
    private static int nb_lignes = 10;
    private static int nb_col = 10;
    private static int nbCases =  nb_lignes * nb_col;
    private static int largeur = 75;
    private static int hauteur = 75;
    private static int nb_pions_noirs = 20;
    private static int nb_pions_blancs = 20;

    @Override
    public void start(Stage stage) throws IOException
    {
        //Vars
        Color couleur;
        double x, y;
        int diametre;
        int countCases = 0;
        String change;
        Scanner sc = new Scanner(System.in);

        //Creation damier
        System.out.print("Voulez-vous personnaliser le damier ? (oui/non)\n>> ");
        change = sc.nextLine();

        try
        {
            if (change.toLowerCase().equals("oui"))
            {
                System.out.print("> Largeur en pixels :\n>> ");
                largeur = sc.nextInt();

                System.out.print("> Hauteur en pixels :\n>> ");
                hauteur = sc.nextInt();

                System.out.print("> Nombre de lignes :\n>> ");
                nb_lignes = sc.nextInt();

                System.out.print("> Nombre de colonnes :\n>> ");
                nb_col = sc.nextInt();

                nbCases = nb_lignes * nb_col;

                System.out.print("> Nombre de pions blancs\n>> ");
                nb_pions_blancs = sc.nextInt();

                System.out.print("> Nombre de pions noirs\n>> ");
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

                    Rectangle r = new Rectangle(i * largeur, j * hauteur, largeur, hauteur);
                    r.setFill(couleur);
                    r.setStroke(Color.BLACK);
                    racine.getChildren().addAll(r);
                    countCases++;

                    //Pions
                    if (i % 2 == j % 2) {
                        x = i * largeur + largeur / 2; //(i+1)*l*0.75; // - i*l/2; //i/2*l;
                        y = j * hauteur + hauteur / 2; // - j*l/2;
                        diametre = (Math.min(largeur, hauteur) - 5) / 2;
                        System.out.println(x + "\n" + y + "\n");

                        if (nb_pions_blancs > 0) {
                            Circle pion = new Circle(x, y, diametre);
                            pion.setFill(Color.WHITE);
                            pion.setStroke(Color.BLACK);
                            nb_pions_blancs--;

                            pion.setStrokeWidth(2);
                            racine.getChildren().addAll(pion);

                        } else if ((nbCases - countCases) / 2 < nb_pions_noirs) {
                            Circle pion = new Circle(x, y, diametre);
                            pion.setFill(Color.BLACK);
                            pion.setStroke(Color.WHITE);
                            nb_pions_noirs--;

                            pion.setStrokeWidth(2);
                            racine.getChildren().addAll(pion);
                        }
                    }
                }
            }
        }
        catch (TropDePionsException e)
        {
            e.printStackTrace();
        }

        Scene scene = new Scene(racine, nb_lignes *largeur, nb_col *hauteur);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}