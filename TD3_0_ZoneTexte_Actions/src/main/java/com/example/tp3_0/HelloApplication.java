package com.example.tp3_0;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();
        HBox btnPanel = new HBox(10);
        Label lblTitle = new Label("Evènements");
        TextArea txaMsg = new TextArea();
        Button btnInsert = new Button("Insérer");
        Button btnDelete = new Button("Supprimer");
        Button btnQuit = new Button("Quitter");

        stage.setTitle("Evènements");
        root.setPadding(new Insets(10));

        //--- Titre
        lblTitle.setFont(Font.font(20));
        lblTitle.setTextFill(Color.DARKGREEN);
        BorderPane.setAlignment(lblTitle, Pos.CENTER);
        root.setTop(lblTitle);

        //--- Text-Area
        txaMsg.setWrapText(true);
        txaMsg.setPrefColumnCount(15);
        txaMsg.setPrefRowCount(10);
        root.setCenter(txaMsg);


        // TODO
        /*
        btnInsert.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                txaMsg.appendText("A");
            }
        });
         */

        btnInsert.setOnMousePressed(mouseEvent -> txaMsg.appendText("A"));
        //btnInsert.setOnMousePressed(mouseEvent -> txaMsg.appendText("B"));


        btnDelete.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        txaMsg.deletePreviousChar();
                    }
                });

        btnQuit.setOnMousePressed(mouseEvent -> Platform.exit());


        btnPanel.getChildren().add(btnInsert);
        btnPanel.getChildren().add(btnDelete);
        btnPanel.getChildren().add(btnQuit);

        btnPanel.setAlignment(Pos.CENTER_RIGHT);
        btnPanel.setPadding(new Insets(10, 0, 0, 0));
        root.setBottom(btnPanel);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}