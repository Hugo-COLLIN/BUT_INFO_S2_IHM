package vue;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modele.Cercle;

public class VueGraphique extends Pane
{
    private final Cercle modele;
    private final Circle rond;
    //private final VueTexte texte;
    public static final int TAILLE_CASE = 50;

    private float vueX, vueY;

    public VueGraphique(Cercle modele, int x, int y) {
        this.modele = modele;
        this.rond = new Circle(50);

        initGrille(x, y);
    }

    public void initGrille (int x, int y)
    {
        for (int i = 0 ; i < x ; i ++)
        {
            for (int j = 0 ; j < y ; j ++)
            {
                Rectangle r = new Rectangle(i, j, TAILLE_CASE, TAILLE_CASE);
                this.getChildren().add(r);
            }
        }
    }

    public void update()
    {
        rond.setCenterX(modele.getX() * TAILLE_CASE);
        rond.setCenterY(modele.getY() * TAILLE_CASE);
        /*texte.update();
        texte.setX(modele.getX() * TAILLE_CASE + DELTA_TEXTE_X);
        texte.setY(modele.getY() * TAILLE_CASE + DELTA_TEXTE_Y);
*/
    }
}
