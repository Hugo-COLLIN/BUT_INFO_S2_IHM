package com.example.td4_1_grillemvc_frommodele.vue;

import com.example.td4_1_grillemvc_frommodele.modele.Cercle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class VueGraphique extends Pane
{
    private final Cercle modele;
    private final Circle rond;
    private final VueTexte texte;
    public static final int TAILLE_CASE = 50;
    public static final int NB_CASES = 10;

    public VueGraphique(Cercle modele, int x, int y) {
        this.modele = modele;
        this.rond = new Circle(TAILLE_CASE * 0.75);
        this.texte = new VueTexte(this.modele);

        initGrille(x, y);
        this.getChildren().add(this.rond);
        this.getChildren().add(this.texte);
    }

    public void initGrille (int x, int y)
    {
        for (int i = 0 ; i < NB_CASES ; i ++)
        {
            for (int j = 0 ; j < NB_CASES ; j ++)
            {
                Rectangle r = new Rectangle(i * TAILLE_CASE, j * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                this.getChildren().add(r);
            }
        }
    }

    public void update()
    {

        rond.setCenterX(modele.getX() * TAILLE_CASE);
        rond.setCenterY(modele.getY() * TAILLE_CASE);

        texte.update();
        texte.setX(modele.getX() * TAILLE_CASE - 12 /*+ DELTA_TEXTE_X*/);
        texte.setY(modele.getY() * TAILLE_CASE /*+ DELTA_TEXTE_Y*/);
    }
}
