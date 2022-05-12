package com.example.td4_1_grillemvc_frommodele.controleur;

import com.example.td4_1_grillemvc_frommodele.modele.Cercle;
import com.example.td4_1_grillemvc_frommodele.vue.VueGraphique;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControleurSouris implements EventHandler<MouseEvent>
{
    private Cercle modele;
    private VueGraphique vue;

    public ControleurSouris (Cercle m, VueGraphique v)
    {
        this.modele = m;
        this.vue = v;
    }

    @Override
    public void handle(MouseEvent e) {
        //Scene s = (Scene)e.getSource();
        modele.setX((int)(Math.ceil(e.getX()) / VueGraphique.TAILLE_CASE)); //+1 / 2
        modele.setY((int)(Math.ceil(e.getY()) / VueGraphique.TAILLE_CASE)); //+1 / 2
        vue.update();
        /*int xI = (int)Math.round(s.getX());
        int yI = (int)Math.round(s.getX());*/
        //modele.setX((int) ((Scene) e.getSource()).getX());
        //modele.setY(yI);
    }
}
