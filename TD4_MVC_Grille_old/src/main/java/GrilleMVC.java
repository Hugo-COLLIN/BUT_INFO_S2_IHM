import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Cercle;
import vue.VueGraphique;

public class GrilleMVC extends Application
{
    private static final int LARGEUR = 500;
    private static final int HAUTEUR = LARGEUR;

    @Override
    public void start(Stage stage) throws Exception {
        Cercle modele = new Cercle(LARGEUR / VueGraphique.TAILLE_CASE, HAUTEUR / VueGraphique.TAILLE_CASE);
        VueGraphique vue = new VueGraphique(modele, LARGEUR, HAUTEUR);
        //vue.setOnMouseMoved(new ControleurSouris(modele, vue));
        Scene scene = new Scene(vue, LARGEUR, HAUTEUR);
        //scene.setOnKeyPressed(new ControleurClavier(modele, vue));

        stage.setTitle("Grille MVC");
        stage.setScene(scene);
        stage.show();
    }






    public static void main(String[] args) {
        launch();
    }


}
