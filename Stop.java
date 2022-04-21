import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Stop extends Application {
    public void start(Stage stage) {
        Pane racine = new Pane();

        // NOTE: Avec le conteneur StackPane, tous les elements sont centres (independamment des coordonnees du centre).

        // Le cercle
        Circle cercle = new Circle(75, 75, 70);
        cercle.setFill(Color.RED);
        cercle.setStroke(Color.BLACK);


        // Le texte au milieu
        Text texte = new Text();
        texte.setFont(Font.font("verdana",  FontWeight.BOLD, FontPosture.REGULAR, 40));
        texte.setFill(Color.WHITE);
        texte.setStroke(Color.BLACK);
        texte.setX(20);
        texte.setY(90);
        texte.setText("STOP");

        // Ajout des elements
        racine.getChildren().addAll(cercle, texte);

        // Gestion de la scene
        Scene scene = new Scene(racine, 150, 150);
        stage.setScene(scene);
        stage.setTitle( "Signe!");

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
