package com.example.td4_serpent_mvc.modele;

import java.util.ArrayList;

public class Jeu
{
    //Attributes
    ArrayList<Position> serpent, murs;
    Position pomme;
    private Position tmp;

    final int TAILLE_SERPENT = 4;
    final int NB_MURS = 15;
    final int TAILLE_CASE = 30;
    final int LARGEUR = 25;
    final int HAUTEUR = 20;

    //Constructor
    public Jeu() {

        boolean autorise = false;

        this.serpent = new ArrayList<Position>();
        this.murs = new ArrayList<Position>();

        for (int i = TAILLE_SERPENT ; i >= 0 ; i --)
        {
            tmp = new Position(i,0);
            this.serpent.add(tmp);
        }

        for (int i = 0 ; i < NB_MURS ; i ++)
            this.murs.add(genererPosAutorisee());
        /*
        for (int i = 0 ; i < NB_MURS ; i ++)
        {
            tmp = new Position(
                    (int) (Math.random() * LARGEUR),
                    (int) (Math.random() * HAUTEUR)
            );

            if (position_autorisee(tmp))
                this.murs.add(tmp);
            else
                i --;
        }

         */

        genererPomme();
    }

    public Jeu(ArrayList<Position> serpent, ArrayList<Position> murs, Position pomme) {
        this.serpent = serpent;
        this.murs = murs;
        this.pomme = pomme;
    }

    //Methods
    // >Générer objets
    private void genererPomme ()
    {
        this.pomme = genererPosAutorisee();
    }

    private Position genererPosAutorisee()
    {
        do
            tmp = new Position(
                    (int) (Math.random() * LARGEUR),
                    (int) (Math.random() * HAUTEUR)
            );
        while (!position_autorisee(tmp));

        return tmp;
    }


    public void jouer_un_coup (Constantes.Direction direction)
    {
        Position tetePos, tmpPos;
        int curX = this.serpent.get(0).getX();
        int curY = this.serpent.get(0).getY();

        switch (direction)
        {
            case HAUT:
                tetePos = new Position(curX, curY - 1);
                break;
            case BAS:
                tetePos = new Position(curX, curY + 1);
                break;
            case GAUCHE:
                tetePos = new Position(curX - 1, curY);
                break;
            case DROITE:
                tetePos = new Position(curX + 1, curY);
                break;
            default:
                tetePos = null;
                break;
        }

        if (position_autorisee(tetePos))
        {
            for (int i = this.serpent.size() - 1 ; i > 0  ; i --)
                this.serpent.set(i, this.serpent.get(i - 1));
            this.serpent.set(0, tetePos);

            if (tetePos == this.pomme)
                genererPomme();

        }


        /*if (position_autorisee(tmpPos))
        {
            for (int i = 1 ; i < this.serpent.size() ; i ++)
            {
                curX = this.serpent.get(i).getX();
                curY = this.serpent.get(i).getY();

                this.serpent.set(i - 1, tmpPos);
                tmpPos = new Position(curX, curY);
            }
            this.serpent.set(this.serpent.size() - 1, tmpPos);
        }*/

        /*
        if (position_autorisee(tmpPos))
        {
            for (int i = 1 ; i <= this.serpent.size() ; i ++)
            {
                curX = this.serpent.get(i).getX();
                curY = this.serpent.get(i).getY();

                this.serpent.set(i - 1, tmpPos);
                tmpPos = new Position(curX, curY);
            }
            this.serpent.set(this.serpent.size() - 1, tmpPos);
        }
         */
    }

    // >Position autorisée
    private boolean position_autorisee(Position posP) {
        return !chercherSuperposition(posP) && dansPlateau(posP);
    }

    private boolean dansPlateau (Position posP)
    {
        return posP.getX() >= 0 && posP.getX() < LARGEUR && posP.getY() >= 0 && posP.getY() < HAUTEUR;
    }

    private boolean chercherSuperposition (Position posP)
    {
        boolean res = false;
        res = chercherSuperposType(posP, this.serpent);
        if (!res) res = chercherSuperposType(posP, this.murs);
        if (!res && this.pomme != null)
            if (this.pomme.equals(posP)) res = true;
        return res;
    }

    private boolean chercherSuperposType (Position posP, ArrayList<Position> listP)
    {
        boolean res = false;
        for (Position p : listP)
            if (p.equals(posP)) {
                res = true;
                break;
            }
        return res;
    }


    // >Affichage
        //recopie
    private char caractere_case (int index_ligne, int index_col)
    {
        Position maCase = new Position(index_ligne, index_col);

        //Test pomme
        if (pomme.equals(maCase))
            return 'P';

        //Test serpent
        for (Position element : this.serpent)
            if (element.equals(maCase))
                return 'S';

        for (Position mur : this.murs)
            if (mur.equals(maCase))
                return 'M';

        return ' ';
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        //Ajout 1re ligne pointillee
        sb.append("-".repeat(LARGEUR + 2) + "\n");

        for (int y = 0 ; y < HAUTEUR ; y ++)
        {
            //Ajout delimiteur au debut
            sb.append("|");
            for (int x = 0 ; x < LARGEUR ; x ++)
                sb.append(caractere_case(x,y));

            //Ajout delimiteur de fin
            sb.append("|");
            //Retour a la ligne
            sb.append("\n");
        }

        //Ajout ligne pointillee fin
        sb.append("-".repeat(LARGEUR + 2) + "\n");

        sb.append(serpent + "\n");
        sb.append(murs + "\n");
        sb.append(pomme + "\n");

        return sb.toString();
    }


}
