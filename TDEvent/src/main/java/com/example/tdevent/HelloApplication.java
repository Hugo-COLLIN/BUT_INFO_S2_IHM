package com.example.tdevent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);

        // CENTER
        VBox pCenter = new VBox();
        Label nomL = new Label("Nom");
        TextField nomF = new TextField();
        Label prenomL = new Label("Prenom");
        TextField prenomF = new TextField();
        Label choixL = new Label("Choix");
        TextArea choixA = new TextArea();

        pCenter.getChildren().addAll(nomL, nomF, prenomL, prenomF, choixL, choixA);
        root.setCenter(pCenter);



        //RIGHT
        GridPane rightP = new GridPane();

        String [] sports = {"Tennis", "Squash", "Natation", "Athlétisme", "Randonnée", "Foot", "Basket", "Volley", "Pétanque"};
        for (int i = 0 ; i < sports.length ; i ++)
        {
            CheckBox check = new CheckBox(sports[i]);
            rightP.add(check, 0, i);

            //Auditeur
            check.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String labelText = check.getText();
                    choixA.appendText(labelText + "\n");
                }
            });
        }

        root.setRight(rightP);

        //BOTTOM
        HBox bottomP = new HBox();
        Button ok = new Button("OK");
        Button annuler = new Button("Annuler");

        bottomP.getChildren().addAll(ok,annuler);
        root.setBottom(bottomP);




        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}