package com.example.td0_mvc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controler implements EventHandler<ActionEvent>
{
    /**
     * Le modele est attribut du controleur
     */
    private ModelCompteur model;
    private VueGraphique vue;
    /**
     * Constructeur
     *
     * @param m l'objet Model
     */
    public Controler(ModelCompteur m, VueGraphique v) {
        this.model=m;
        this.vue=v;
    }

    /**
     * Methode
     * lancee quand un evenement a lieu sur un des
     * composants sous ecoute - ici les 2 boutons
     *
     * @param e ActionEvent obtenu apres clic
     * sur un des deux boutons
     */
    public void handle (ActionEvent e) {
        Button b = (Button)e.getSource();
        if(b.getText().equals("Plus"))
            model.modifier(1);
        if(b.getText().equals("Moins"))
            model.modifier(-1);
        vue.update();
    }
}
