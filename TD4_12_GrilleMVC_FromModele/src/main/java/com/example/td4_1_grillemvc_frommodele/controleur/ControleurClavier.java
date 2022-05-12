package com.example.td4_1_grillemvc_frommodele.controleur;

import com.example.td4_1_grillemvc_frommodele.modele.Cercle;
import com.example.td4_1_grillemvc_frommodele.vue.VueGraphique;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControleurClavier implements EventHandler<KeyEvent>
{
    private Cercle modele;
    private VueGraphique vue;

    public ControleurClavier(Cercle m, VueGraphique v)
    {
        this.modele = m;
        this.vue = v;
    }

    @Override
    public void handle(KeyEvent e) {
        modele.to(e.getCode());
        vue.update();
    }
}
