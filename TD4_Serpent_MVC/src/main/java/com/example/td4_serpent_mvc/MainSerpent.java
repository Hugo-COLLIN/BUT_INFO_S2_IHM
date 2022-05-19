package com.example.td4_serpent_mvc;

import com.example.td4_serpent_mvc.modele.Constantes;
import com.example.td4_serpent_mvc.modele.Jeu;

public class MainSerpent
{
    public static void main(String[] args) {
        Jeu j = new Jeu();
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.DROITE);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.DROITE);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.BAS);
        System.out.println(j);

        j.jouer_un_coup(Constantes.Direction.GAUCHE);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.BAS);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.DROITE);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.DROITE);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.BAS);
        System.out.println(j);
        j.jouer_un_coup(Constantes.Direction.HAUT);
        System.out.println(j);



    }
}
