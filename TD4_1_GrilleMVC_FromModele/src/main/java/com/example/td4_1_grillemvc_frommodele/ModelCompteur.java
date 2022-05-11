package com.example.td4_1_grillemvc_frommodele;

public class ModelCompteur
{

    /**
     * compteur
     */
    private int compteur;

    /**
     * Constructeur - met le compteur a 0
     */
    public ModelCompteur(){
        this.compteur=0;
    }

    /**
     * modifie la valeur de compteur en fonction du parametre
     *
     * @param incr entiere a ajouter au compteur
     */
    public void modifier(int incr){
        this.compteur+=incr;
    }

    /**
     * @return the compteur
     */
    public int getCompteur() {
        return compteur;
    }

}
