package com.example.td31;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();

        RadioButton mme = new RadioButton("Madame");
        RadioButton mr = new RadioButton("Monsieur");

        root.addRow(0,mme,mr);

        Node[] l1 = {new Text("Nom"), new TextField(), new Text("Prénom"), new TextField()};
        for (int i = 0 ; i < l1.length ; i ++)
        {
            root.add(l1[i],i, 1);
        }

        Node[] l2 = {new Text("Email"), new TextField()};
        GridPane.setColumnSpan(l2[1], 3);
        for (int i = 0 ; i < l2.length ; i ++)
        {
            root.add(l2[i], i, 2);
        }

        Node[] l3 = {new Text(""), new Button("Précédent"), new Button("Suivant")};
        for (int i = 0 ; i < l3.length ; i ++)
        {
            l1[i].maxWidth(Double.MAX_VALUE);
            root.add(l3[i],i, 3);
        }

        /*
        Text nomT = new Text("Nom");
        TextField nomF = new TextField();

        Text prenomT = new Text("Prénom");
        TextField prenomF = new TextField();

        root.addRow(1, nomT, nomF, prenomT, prenomF);
        */

        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}