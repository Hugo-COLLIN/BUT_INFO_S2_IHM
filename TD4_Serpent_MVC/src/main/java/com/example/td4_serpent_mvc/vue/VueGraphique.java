package com.example.td4_serpent_mvc.vue;

import com.example.td4_serpent_mvc.modele.Jeu;
import com.example.td4_serpent_mvc.modele.Position;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class VueGraphique extends GridPane {
    // Lien vers le modèle
    private Jeu jeu;
    // Attributs graphiques
    private Rectangle pomme;
    private ArrayList<Rectangle> serpent;
    private ArrayList<Rectangle> murs;

    Rectangle tmp;
    final int TAILLE_CASE = 30;


    public VueGraphique ()
    {
        buildLaby();
        buildSerpent();
        buildMurs();
        buildPomme();
        this.pomme.setFill(Color.RED);
        this.pomme.setStroke(Color.BLACK);
        /*
        for (Position s : jeu.getSerpent())
        {
            tmp = new Rectangle(TAILLE_CASE, TAILLE_CASE);
            this.getChildren().add(tmp, )
            this.serpent.add(tmp);
        }
        */

        buildRect(this.serpent.get(0), Color.ORANGE);
        for (int i = 1 ; i < this.serpent.size() ; i ++)
            buildRect(this.serpent.get(i), Color.YELLOW);

        for (Rectangle m : murs)
            buildRect(m, Color.BLACK);
        /*
        {
            tmp = this.serpent.get(i);
            tmp.setFill(Color.YELLOW);
        }

        for (Rectangle m : murs)
        {
            m.setFill(Color.BLACK);
        }

         */
    }

    // >Crea
    private void buildLaby()
    {

    }
    private void buildSerpent()
    {}
    private void buildMurs(){}
    private void buildPomme(){}
    private void buildRect (Rectangle r, Color fill)
    {
        tmp = this.serpent.get(0);
        tmp.setFill(fill);
        tmp.setStroke(Color.BLACK);
    }
    private static void bougeRectangle(Rectangle rectangle, Position position)
    {
        GridPane.setColumnIndex(rectangle, position.getX());
        GridPane.setRowIndex(rectangle, position.getY());
    }

    public void update() {
        // Étape 1 : Actualisation de la pomme
        bougeRectangle(pomme, jeu.getPomme());

        // Étape 2 : Actualisation du serpent
        ArrayList<Position> serpentModele = jeu.getSerpent();

        // Actualisation de toutes les positions du serpent
        for (int i = 0; i < serpentModele.size(); i++) {
            Rectangle elemVue = serpent.get(i);
            Position elemModele = serpentModele.get(i);

            bougeRectangle(elemVue, elemModele);
        }
    }
}
/*
public class VueGraphique
{
    ArrayList<Rectangle> cases;

    /*
    public void update()
    {
        bougeRect(imgPomme, jeu.getPomme());

        //Actualiser ttes les pos du serpent
        for (int i = 0 ; i < serpentModele.size() ; i ++)
        {
            Rect elementGraphique = serpent.get(i);
            Position elementModele = serpentModele.get(i);
            bougeRect(elementGraphique, elementModele);
        }

        //Etape 3 : actu murs
        ArrayList<Position> mursModele = jeu.getMurs();
        if (murs.size() > mursModele.size())
            throw  new Error("Le nbr de murs du graphique excède celui du modele...");
    }

}*/
