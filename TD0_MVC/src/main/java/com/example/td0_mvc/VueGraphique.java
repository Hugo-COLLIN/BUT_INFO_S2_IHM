package com.example.td0_mvc;

import javafx.scene.control.Label;

public class VueGraphique extends Label
{
    private ModelCompteur mod;
    /**
     * Constructeur - positionne la valeur 0 au centre du JLabel
     */
    public VueGraphique(ModelCompteur m) {
        super("0");
        this.mod=m;
    }

    /**
     * Actualisation du Label avec la nouvelle valeur du compteur obtenue grace au modele mod
     * Methode lancee a chaque modification du modele
     */
    public void update() {
        this.setText(""+ mod.getCompteur());

    }

}
