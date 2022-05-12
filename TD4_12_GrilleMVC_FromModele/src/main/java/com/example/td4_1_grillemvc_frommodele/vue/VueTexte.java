package com.example.td4_1_grillemvc_frommodele.vue;

import com.example.td4_1_grillemvc_frommodele.modele.Cercle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VueTexte extends Text
{
    private final Cercle modele;

    public VueTexte (Cercle m)
    {
        super("(0,0)");
        this.modele = m;

        this.setFill(Color.WHITE);

    }

    public void update ()
    {
        this.setText("(" + modele.getX() + "," + modele.getY() + ")");
    }
}
