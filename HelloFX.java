import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import  javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloFX extends Application {
    public void start(Stage stage) {
        Pane racine = new Pane();
        Button btn = new Button("Bonjour!");
        Rectangle rect = new Rectangle(140, 70, Color.LIGHTGRAY);
        racine.getChildren().addAll(rect, btn);

        Scene scene = new Scene(racine, 150, 100);
        stage.setScene(scene);
        stage.setTitle("Hello World!");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
